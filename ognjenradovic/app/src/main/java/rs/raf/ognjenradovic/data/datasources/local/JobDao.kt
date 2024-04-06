package rs.raf.ognjenradovic.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.ognjenradovic.data.models.JobEntity

@Dao
abstract class JobDao {
    @Query("SELECT * FROM jobs")
    abstract fun getAllJobs(): Observable<List<JobEntity>>

    @Transaction
    open fun deleteAndInsertAllJobs(entities: List<JobEntity>) {
        deleteAll()
        insertAll(entities).blockingAwait()
    }

    @Query("DELETE FROM jobs")
    abstract fun deleteAll()

    @Insert( onConflict = OnConflictStrategy.IGNORE )
    abstract fun insertAll(entities: List<JobEntity>): Completable

    @Query("SELECT * FROM jobs WHERE id = :id")
    abstract fun getJobById(id: String): Observable<JobEntity>

}

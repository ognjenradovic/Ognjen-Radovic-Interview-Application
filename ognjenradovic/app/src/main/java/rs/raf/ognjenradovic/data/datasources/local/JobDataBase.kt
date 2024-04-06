package rs.raf.ognjenradovic.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.ognjenradovic.data.models.JobEntity

@Database(
    entities = [JobEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class JobDataBase : RoomDatabase() {
    abstract fun getJobDao(): JobDao
}

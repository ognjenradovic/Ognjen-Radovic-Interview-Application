import io.reactivex.Observable
import rs.raf.ognjenradovic.data.datasources.local.JobDao
import rs.raf.ognjenradovic.data.datasources.remote.JobService
import rs.raf.ognjenradovic.data.models.*
import rs.raf.ognjenradovic.data.repositories.JobRepository

class JobRepositoryImpl(
    private val localDataSource: JobDao,
    private val remoteDataSource: JobService
) : JobRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .map {
                val jobs = it.jobs
                val entities = jobs.map {
                    JobEntity(
                        it.id,
                        it.name,
                        it.salary,
                        it.imageURL,
                        it.technologies,
                        it.description,
                        it.logoURL,
                        it.companyName,
                        it.companyDescription
                    )
                }
                localDataSource.deleteAndInsertAllJobs(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

//    override fun fetchAll(): Observable<Resource<Unit>> {
//        // Implementation for fetching data from remote and local sources
//    }

    override fun getAll(): Observable<JobWrapper> {
        return localDataSource
            .getAllJobs()
            .map { jobs ->
                JobWrapper(
                    jobs.map { job ->
                        Job(
                            job.id,
                            job.name,
                            job.salary,
                            job.imageURL,
                            job.technologies,
                            job.description,
                            job.logoURL,
                            job.companyName,
                            job.companyDescription
                        )
                    }
                )
            }
    }

    override fun getJobById(id: String): Observable<Job> {
        return localDataSource
            .getJobById(id)
            .map { job ->
                Job(
                    job.id,
                    job.name,
                    job.salary,
                    job.imageURL,
                    job.technologies,
                    job.description,
                    job.logoURL,
                    job.companyName,
                    job.companyDescription
                )
            }
    }
}

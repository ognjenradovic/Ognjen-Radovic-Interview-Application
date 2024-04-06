package rs.raf.ognjenradovic.data.datasources.remote


import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.ognjenradovic.data.models.AllJobsResponse

interface JobService {

    @GET("/")
    fun getAll(): Observable<AllJobsResponse>

}

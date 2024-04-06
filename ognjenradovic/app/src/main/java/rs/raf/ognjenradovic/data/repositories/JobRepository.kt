package rs.raf.ognjenradovic.data.repositories

import io.reactivex.Observable
import rs.raf.ognjenradovic.data.models.*

interface JobRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<JobWrapper>
    fun getJobById(id: String) :  Observable<Job>
//    fun getAllByName(name: String): Observable<List<Category>>

}
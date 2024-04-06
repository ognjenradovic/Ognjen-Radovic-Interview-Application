package rs.raf.ognjenradovic.presentation.view.states

import rs.raf.ognjenradovic.data.models.Job
import rs.raf.ognjenradovic.data.models.JobWrapper

sealed class JobDetailsState {
    object Loading: JobDetailsState()
    object DataFetched: JobDetailsState()
    data class Success(val job: Job): JobDetailsState()
    data class Error(val message: String): JobDetailsState()
}
package rs.raf.ognjenradovic.presentation.view.states

import rs.raf.ognjenradovic.data.models.JobWrapper

sealed class JobsState {
    object Loading: JobsState()
    object DataFetched: JobsState()
    data class Success(val job: JobWrapper): JobsState()
    data class Error(val message: String): JobsState()
}
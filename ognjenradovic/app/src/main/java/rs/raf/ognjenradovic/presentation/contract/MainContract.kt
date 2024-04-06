package rs.raf.ognjenradovic.presentation.contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rs.raf.ognjenradovic.presentation.view.states.*

interface MainContract {

    interface ViewModel1 {
        val jobsState: LiveData<JobsState>
        fun fetchAllJobs()
        fun getAllJobs()
    }

}
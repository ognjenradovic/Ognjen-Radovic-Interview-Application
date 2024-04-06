package rs.raf.ognjenradovic.presentation.contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rs.raf.ognjenradovic.presentation.view.states.*

interface SecondContract {

    interface ViewModel2 {
        val jobDetailsState: LiveData<JobDetailsState>
        fun getJobById(id: String)
    }

}
package rs.raf.ognjenradovic.presentation.view.fragments.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.ognjenradovic.data.models.*
import rs.raf.ognjenradovic.data.repositories.JobRepository
import rs.raf.ognjenradovic.presentation.contract.MainContract
import rs.raf.ognjenradovic.presentation.contract.SecondContract
import rs.raf.ognjenradovic.presentation.view.states.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SecondViewModel(private val jobRepository: JobRepository) : ViewModel(), SecondContract.ViewModel2 {

    private val subscriptions = CompositeDisposable()
    override val jobDetailsState: MutableLiveData<JobDetailsState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()
    private val jobPublishSubject: PublishSubject<String> = PublishSubject.create()


    init {


//        val jobSubscription = publishSubject
//            .debounce(200, TimeUnit.MILLISECONDS)
//            .distinctUntilChanged()
//            .switchMap {
//                jobRepository
//                    .getJobById()
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .doOnError {
//                        Timber.e("Error in JOB")
//                        Timber.e(it)
//                    }
//            }
//            .subscribe(
//                {
//                    jobDetailsState.value = JobDetailsState.Success(it)
//                },
//                {
//                    jobDetailsState.value = JobDetailsState.Error("Error happened while fetching JOB from db")
//                    Timber.e(it)
//                }
//            )
//        subscriptions.add(jobSubscription)

    }






//
//
//
//         fun fetchAllJobs() {
//            val subscription = jobRepository
//                .fetchAll()
//                .startWith(Resource.Loading())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    { response ->
//                        if (response is Resource.Success<Unit>) {
//                            jobsState.value = JobsState.DataFetched;
//                        } else if (response is Resource.Loading) {
//                            jobsState.value = JobsState.Loading;
//                        } else {
//                            jobsState.value =
//                                JobsState.Error("Unexpected response or error occurred")
//
//                        }
//                    },
//                    { error ->
//                        jobsState.value =
//                            JobsState.Error("Error happened while fetching JOB data from the server")
//
//                    }
//                )
//
//            subscriptions.add(subscription)
//
//        }
//
//
         override fun getJobById(id: String) {
            val subscription = jobRepository
                .getJobById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        jobDetailsState.value = JobDetailsState.Success(it)
                    },
                    {
                        jobDetailsState.value =
                            JobDetailsState.Error("Error happened while fetching data from db")
                        Timber.e(it)
                    }
                )
            subscriptions.add(subscription)
        }

        override fun onCleared() {
            super.onCleared()
            subscriptions.dispose()
        }

}
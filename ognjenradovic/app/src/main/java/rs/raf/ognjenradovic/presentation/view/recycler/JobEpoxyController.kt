package rs.raf.ognjenradovic.presentation.view.recycler

import com.airbnb.epoxy.AsyncEpoxyController
import rs.raf.ognjenradovic.data.models.Job
import rs.raf.ognjenradovic.data.models.JobEpoxyModel

class JobEpoxyController(private val onItemClick: (Job) -> Unit) : AsyncEpoxyController() {

    private var jobs: List<Job> = emptyList()

    fun setData(jobs: List<Job>) {
        this.jobs = jobs
        requestModelBuild()
    }


    override fun buildModels() {
        jobs.forEach { job ->
            JobEpoxyModel (
                job.id,
                job.name,
                job.salary,
                job.imageURL,
                onItemClick

            )
        }
    }


    }

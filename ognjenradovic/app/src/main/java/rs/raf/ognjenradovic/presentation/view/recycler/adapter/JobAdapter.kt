package rs.raf.ognjenradovic.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.ognjenradovic.data.models.Job
import rs.raf.ognjenradovic.databinding.LayoutItemJobBinding
import rs.raf.ognjenradovic.presentation.view.recycler.diff.JobDiffCallBack
import rs.raf.ognjenradovic.presentation.view.recycler.viewholder.JobViewHolder

class JobAdapter(private val onItemClick: (Job) -> Unit) : ListAdapter<Job, JobViewHolder>(JobDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemBinding = LayoutItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }
}

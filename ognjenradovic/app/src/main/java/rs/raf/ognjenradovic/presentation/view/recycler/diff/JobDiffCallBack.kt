package rs.raf.ognjenradovic.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.ognjenradovic.data.models.Job

class JobDiffCallBack : DiffUtil.ItemCallback<Job>() {

    override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem.name == newItem.name
    }

}
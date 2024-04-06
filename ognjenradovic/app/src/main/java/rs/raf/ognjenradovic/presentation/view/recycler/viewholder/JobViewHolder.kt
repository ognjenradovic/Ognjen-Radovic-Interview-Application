package rs.raf.ognjenradovic.presentation.view.recycler.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import rs.raf.ognjenradovic.data.models.Job
import rs.raf.ognjenradovic.databinding.LayoutItemJobBinding

class JobViewHolder(private val itemBinding: LayoutItemJobBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(job: Job, onItemClick: (Job) -> Unit) {
        itemBinding.title1.text = job.name;
        itemBinding.title2.text = job.salary;
        Picasso.get().load(job.imageURL).into(itemBinding.imageView)
        itemBinding.root.setOnClickListener {
            onItemClick(job)
        }
    }

//    private fun showDescriptionPopup(description: String) {
//        val rootView = itemBinding.root
//        Snackbar.make(rootView, description, Snackbar.LENGTH_LONG).show()
//    }
}
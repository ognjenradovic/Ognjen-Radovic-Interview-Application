package rs.raf.ognjenradovic.data.models;

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass;

import rs.raf.ognjenradovic.R;

@EpoxyModelClass(layout = R.layout.layout_item_job)
data class JobEpoxyModel(
    val id: String,
    val name: String,
    val salary: String,
    val imageUrl: String,
    val clickListener: (Job) -> Unit
) : EpoxyModel<Job>() {


    //    override fun id(hashCode: Long): Long {
//        return id.toLong()
//    }
    override fun getDefaultLayout(): Int {
        return R.layout.layout_item_job
    }
    override fun id(hashCode: Long): EpoxyModel<Job>? {
        return this;
    }

//    override fun bind(holder: Holder) {
//        super.bind(holder)
//
//        holder.textView(R.id.jobNameTextView).text = name
//        holder.imageView(R.id.jobImageView).setImageResource(imageUrl)  // Adjust for loading from URL if needed
//        holder.clickListener(this)
//    }
}







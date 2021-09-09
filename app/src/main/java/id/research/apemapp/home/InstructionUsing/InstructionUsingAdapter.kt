package id.research.apemapp.home.InstructionUsing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.research.apemapp.databinding.ItemInstructionBinding
import id.research.apemapp.models.InstructionItemEntity

class InstructionUsingAdapter :
    RecyclerView.Adapter<InstructionUsingAdapter.viewPagerHolderView>() {

    private var listInstruction = ArrayList<InstructionItemEntity>()

    fun setListInstruction(listInstruction: ArrayList<InstructionItemEntity>) {
        if (listInstruction == null) return
        this.listInstruction.clear()
        this.listInstruction.addAll(listInstruction)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstructionUsingAdapter.viewPagerHolderView {
        val itemInstructionBinding =
            ItemInstructionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewPagerHolderView(itemInstructionBinding)
    }

    override fun onBindViewHolder(
        holder: InstructionUsingAdapter.viewPagerHolderView,
        position: Int
    ) {
        val list = listInstruction[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return listInstruction.size
    }

    class viewPagerHolderView(private val binding: ItemInstructionBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(listItem: InstructionItemEntity){
                with(binding){
                    tvInstruction.text = listItem.name

                    Glide.with(itemView.context)
                        .load(listItem.image)
                        .into(imgInstruction)
                }

            }
    }
}
package id.research.apemapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.research.apemapp.R
import id.research.apemapp.model.Koleksi

class KoleksiAdapter(private val listKata: ArrayList<Koleksi>) : RecyclerView.Adapter<KoleksiAdapter.listKataHolderView>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

//    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listKataHolderView {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kamus, parent, false)
        return listKataHolderView(view)
    }

    override fun getItemCount(): Int {
        return listKata.size
    }

    override fun onBindViewHolder(holder: listKataHolderView, position: Int) {
        val kamus = listKata[position]

        holder.tvKata.text = kamus.kata
        holder.tvArti.text = kamus.arti

//        holder.itemView.setOnClickListener {
//            if (::onItemClickCallback.isInitialized){
//                onItemClickCallback.onItemClicked(listKata[holder.adapterPosition])
//            }
//        }

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKata[holder.adapterPosition]) }

//        holder.itemView.setOnClickListener {
//            onItemClickCallback?.onItemClicked(listKata[holder.adapterPosition])
//        }
    }

    inner class listKataHolderView(itemView:View): RecyclerView.ViewHolder(itemView){
        var tvKata: TextView = itemView.findViewById(R.id.tv_kata)
        var tvArti: TextView = itemView.findViewById(R.id.tv_arti)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Koleksi)
    }

}

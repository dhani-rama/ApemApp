package id.research.apemapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import id.research.apemapp.activity.DictionaryDetailListActivity
import id.research.apemapp.databinding.ItemDictionaryBinding
import id.research.apemapp.model.DictionaryItemEntity
import java.util.*
import kotlin.collections.ArrayList

class DictionaryListAdapter : RecyclerView.Adapter<DictionaryListAdapter.listWordHolderView>(),
    Filterable {

    private var listWord = ArrayList<DictionaryItemEntity>()
    private var listWordFilter = ArrayList<DictionaryItemEntity>()

    fun setListWord(listWord: ArrayList<DictionaryItemEntity>?) {
        if (listWord == null) return
        this.listWord.clear()
        this.listWord.addAll(listWord)

        this.listWordFilter = listWord
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): listWordHolderView {
        val itemDictionaryBinding =
            ItemDictionaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return listWordHolderView(itemDictionaryBinding)
    }

    override fun onBindViewHolder(holder: listWordHolderView, position: Int) {
        val dictionary = listWord[position]
        holder.bind(dictionary)
    }

    override fun getItemCount(): Int {
        return listWord.size
    }

    class listWordHolderView(private val binding: ItemDictionaryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wordItem: DictionaryItemEntity) {
            with(binding) {
                tvWord.text = wordItem.kata
                tvMeaning.text = wordItem.arti

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DictionaryDetailListActivity::class.java)
                        .apply {
                            putExtra(DictionaryDetailListActivity.EXTRA_WORD, wordItem.kata)
                            putExtra(DictionaryDetailListActivity.EXTRA_MEANING, wordItem.arti)
                        }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (constraint == null || constraint.length < 0) {
                    filterResults.count = listWordFilter.size
                    filterResults.values = listWordFilter
                } else {
                    val charSearch = constraint.toString()
                    val resultList = ArrayList<DictionaryItemEntity>()

                    for (row in listWordFilter) {
                        if (row.kata.toLowerCase(Locale.getDefault()).contains(
                                charSearch.toLowerCase(
                                    Locale.getDefault()
                                )
                            )
                        ) {
                            resultList.add(row)
                        }
                    }

                    filterResults.count = resultList.size
                    filterResults.values = resultList
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listWord = results?.values as ArrayList<DictionaryItemEntity>
                notifyDataSetChanged()
            }

        }
    }

}
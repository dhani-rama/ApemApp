package id.research.apemapp.Dictionary

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.Models.DictionaryItemEntity
import kotlinx.android.synthetic.main.fragment_dictionary.*


class DictionaryFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dictionary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_search.setOnClickListener {
            val search = Intent(this@DictionaryFragment.requireContext(), DictionaryListActivity::class.java)
            startActivity(search)
        }
    }
}
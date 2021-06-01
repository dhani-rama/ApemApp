package id.research.apemapp.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.activity.DetailKamusActivity
import id.research.apemapp.adapter.KoleksiAdapter
import id.research.apemapp.model.Koleksi
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.fragment_kamus.*


class KamusFragment : Fragment() {

    private lateinit var mDatabase: DatabaseReference
    private lateinit var mRecyclerview: RecyclerView
    private lateinit var mWord: ArrayList<Koleksi>
    private lateinit var mLoading: ProgressDialog

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kamus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_search.setOnClickListener {
            val search = Intent(this@KamusFragment.requireContext(), DetailKamusActivity::class.java)
            startActivity(search)
            activity?.finish()
        }
//
//        mRecyclerview = requireActivity()!!.findViewById(R.id.rv_item)
//
//        mRecyclerview.layoutManager = LinearLayoutManager(this.requireContext())
//        mRecyclerview.setHasFixedSize(true)
//
//        mWord = arrayListOf<Koleksi>()

        //ambilData()
    }

//    private fun ambilData() {
//        mDatabase = FirebaseDatabase.getInstance().getReference("Kamus")
//
//        mDatabase.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//                mLoading.show()
//                Toast.makeText(this@KamusFragment.requireContext(), "${error.message}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//               if(snapshot.exists()){
//                   for(item in snapshot.children){
//                       val koleksi = item.getValue(Koleksi::class.java)
//                       mWord.add(koleksi!!)
//                   }
//
//                   mRecyclerview.adapter = KoleksiAdapter(mWord)
//
//               }
//            }
//
//        })
//    }

}
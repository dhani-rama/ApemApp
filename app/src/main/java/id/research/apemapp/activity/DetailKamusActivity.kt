package id.research.apemapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.adapter.KoleksiAdapter
import id.research.apemapp.fragment.KamusFragment
import id.research.apemapp.model.Koleksi
import kotlinx.android.synthetic.main.activity_detail_kamus.*

class DetailKamusActivity : AppCompatActivity() {

    private lateinit var mDatabase: DatabaseReference
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mWord: ArrayList<Koleksi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kamus)

        mRecyclerView = findViewById(R.id.rv_list)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)

        mWord = arrayListOf<Koleksi>()

        ambilData()
    }

    private fun ambilData() {
        mDatabase = FirebaseDatabase.getInstance().getReference("Kamus")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailKamusActivity, "{$error.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val koleksi = item.getValue(Koleksi::class.java)
                        mWord.add(koleksi!!)
                    }

                    val adapterKamus = KoleksiAdapter(mWord)
                    mRecyclerView.adapter = adapterKamus

                    adapterKamus.setOnItemClickCallback(object : KoleksiAdapter.OnItemClickCallback {
                        override fun onItemClicked(data: Koleksi) {
                            val intent = Intent(this@DetailKamusActivity, DetailListActivity::class.java)
                            intent.putExtra(DetailListActivity.EXTRA_KATA, data.kata)
                            intent.putExtra(DetailListActivity.EXTRA_ARTI, data.arti)

                            startActivity(intent)
                        }
                    })
                }
            }
        })

        val fragmentKamus = KamusFragment()
        val fragment = supportFragmentManager.findFragmentByTag(KamusFragment::class.java.simpleName)

        btn_kembali.setOnClickListener {

//            supportFragmentManager.beginTransaction()
//                    .add(R.id.container, fragmentKamus, KamusFragment::class.java.simpleName)
//                    .commit()

        }
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_search, menu)
//
//        val search = menu?.findItem(R.id.search)
//        val searchView = search?.actionView as? SearchView
//        searchView?.isSubmitButtonEnabled = true
//
//    }
}
package id.research.apemapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
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

class DetailKamusActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var mDatabase: DatabaseReference
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mWord: ArrayList<Koleksi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kamus)

        //support custom toolbar
        setSupportActionBar(toolbar_search)
        //ganti app name
        supportActionBar?.setTitle("Kamus A-PEM")

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
                Toast.makeText(this@DetailKamusActivity, "{$error.message}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val koleksi = item.getValue(Koleksi::class.java)
                        mWord.add(koleksi!!)
                    }

                    val adapterKamus = KoleksiAdapter(mWord)
                    mRecyclerView.adapter = adapterKamus

                    adapterKamus.setOnItemClickCallback(object :
                        KoleksiAdapter.OnItemClickCallback {
                        override fun onItemClicked(data: Koleksi) {
                            val intent =
                                Intent(this@DetailKamusActivity, DetailListActivity::class.java)
                            intent.putExtra(DetailListActivity.EXTRA_KATA, data.kata)
                            intent.putExtra(DetailListActivity.EXTRA_ARTI, data.arti)

                            startActivity(intent)
                        }
                    })
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val search = menu!!.findItem(R.id.search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchData(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchData(query)
        }
        return true
    }

    private fun searchData(query: String) {

        val queryUser = FirebaseDatabase.getInstance().reference
            .child("Kamus")
            .orderByChild("kata")
            .startAt(query)
            .endAt(query + "\uf8ff")


        queryUser.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                mWord.clear()

                if (snapshot.exists()){
                    for(item in snapshot.children){
                        val koleksi = item.getValue(Koleksi::class.java)
                        mWord.add(koleksi!!)
                    }

                    val adapterKamus = KoleksiAdapter(mWord)
                    mRecyclerView.adapter = adapterKamus

                    adapterKamus.setOnItemClickCallback(object : KoleksiAdapter.OnItemClickCallback{
                        override fun onItemClicked(data: Koleksi) {
                            val intent = Intent(this@DetailKamusActivity, DetailListActivity::class.java)

                            intent.putExtra(DetailListActivity.EXTRA_KATA, data.kata)
                            intent.putExtra(DetailListActivity.EXTRA_ARTI, data.arti)

                            startActivity(intent)
                        }
                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailKamusActivity, "{$error.message}", Toast.LENGTH_SHORT)
                    .show()
            }

        })

    }

}


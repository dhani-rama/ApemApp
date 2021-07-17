package id.research.apemapp.Dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityDictionaryListBinding
import id.research.apemapp.Models.DictionaryItemEntity
import id.research.apemapp.util.MySharedPreferences

class DictionaryListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var dictionaryListBinding: ActivityDictionaryListBinding
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mWord: ArrayList<DictionaryItemEntity>
    private lateinit var dictionaryListAdapter: DictionaryListAdapter
    private lateinit var myPreferences: MySharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dictionaryListBinding = ActivityDictionaryListBinding.inflate(layoutInflater)
        setContentView(dictionaryListBinding.root)

        setSupportActionBar(dictionaryListBinding.toolbarSearch)

        supportActionBar?.setTitle("Kamus A-PEM")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        dictionaryListAdapter = DictionaryListAdapter()

        mWord = arrayListOf<DictionaryItemEntity>()

        getDataWord()

    }

    private fun getDataWord(){

        mDatabase = FirebaseDatabase.getInstance().getReference("Dictionary")

        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (item in snapshot.children){
                        val collection = item.getValue(DictionaryItemEntity::class.java)
                        mWord.add(collection!!)
                    }

                    dictionaryListAdapter.setListWord(mWord)

                    with(dictionaryListBinding.rvList){
                        layoutManager = LinearLayoutManager(this@DictionaryListActivity)
                        setHasFixedSize(true)
                        adapter = dictionaryListAdapter
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DictionaryListActivity, "{$error.message}", Toast.LENGTH_SHORT).show()
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
        dictionaryListAdapter.filter.filter(query)
        return false
    }

    override fun onQueryTextChange(query: String?): Boolean {
        dictionaryListAdapter.filter.filter(query)
        return false
    }

}
package id.research.apemapp.Dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityDictionaryDetailListBinding

class DictionaryDetailListActivity : AppCompatActivity() {

    private lateinit var dictionaryDetailListBinding: ActivityDictionaryDetailListBinding

    companion object{
        const val EXTRA_WORD = "word"
        const val EXTRA_MEANING = "meaning"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dictionaryDetailListBinding = ActivityDictionaryDetailListBinding.inflate(layoutInflater)
        setContentView(dictionaryDetailListBinding.root)

//        dictionaryDetailListBinding.btnBack.setOnClickListener(){
//            val intent = Intent(this@DictionaryDetailListActivity, DictionaryListActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        dictionaryDetailListBinding.tvWord.text = intent.getStringExtra(EXTRA_WORD)
        dictionaryDetailListBinding.tvMeaning.text = intent.getStringExtra(EXTRA_MEANING)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
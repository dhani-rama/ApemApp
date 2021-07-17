package id.research.apemapp.Dictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityDictionaryDetailListBinding
import id.research.apemapp.util.Constants

class DictionaryDetailListActivity : AppCompatActivity() {

    private lateinit var dictionaryDetailListBinding: ActivityDictionaryDetailListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dictionaryDetailListBinding = ActivityDictionaryDetailListBinding.inflate(layoutInflater)
        setContentView(dictionaryDetailListBinding.root)

        dictionaryDetailListBinding.btnBack.setOnClickListener{
            val intent = Intent(this@DictionaryDetailListActivity, DictionaryListActivity::class.java)
            startActivity(intent)
            finish()
        }

        dictionaryDetailListBinding.tvWord.text = intent.getStringExtra(Constants.EXTRA_WORD)
        dictionaryDetailListBinding.tvMeaning.text = intent.getStringExtra(Constants.EXTRA_MEANING)
    }
}
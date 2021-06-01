package id.research.apemapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.R
import kotlinx.android.synthetic.main.activity_detail_list.*

class DetailListActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_KATA = "kata"
        const val EXTRA_ARTI = "arti"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_list)

        btn_kembali.setOnClickListener {
            val kembali = Intent(this@DetailListActivity, DetailKamusActivity::class.java)
            startActivity(kembali)
            finish()
        }

        tv_kata.text = intent.getStringExtra(EXTRA_KATA)
        tv_arti.text = intent.getStringExtra(EXTRA_ARTI)

    }
}
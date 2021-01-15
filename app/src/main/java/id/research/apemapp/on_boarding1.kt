package id.research.apemapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_on_boarding1.*

class on_boarding1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding1)

        btn_lanjut.setOnClickListener {
            val lanjut = Intent(this@on_boarding1, on_boarding2::class.java )
            startActivity(lanjut)
        }
    }
}
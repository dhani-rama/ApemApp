package id.research.apemapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tv_masuk.setOnClickListener {
            val daftar = Intent(this@sign_in, sign_up::class.java)
            startActivity(daftar)
            finish()
        }
    }
}
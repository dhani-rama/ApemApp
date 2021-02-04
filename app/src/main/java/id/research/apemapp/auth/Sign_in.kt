package id.research.apemapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class Sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tv_masuk.setOnClickListener {
            startActivity(Intent(this@Sign_in, Sign_up::class.java))
            finish()
        }

        btn_lanjut.setOnClickListener {
            startActivity(Intent(this@Sign_in, HomeActivity::class.java))
            finish()
        }
    }
}
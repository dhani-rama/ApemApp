package id.research.apemapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tv_masuk.setOnClickListener {
            val masuk = Intent(this@sign_up, sign_in::class.java)
            startActivity(masuk)
            finish()
        }
    }
}
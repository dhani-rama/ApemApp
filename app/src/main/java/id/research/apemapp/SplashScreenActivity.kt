package id.research.apemapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.research.apemapp.R
import id.research.apemapp.Auth.SignInActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class on_boarding1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val lanjut = Intent(this@on_boarding1, SignInActivity::class.java)
            startActivity(lanjut)
            finish()
        }, 3000)
    }
}
package id.research.apemapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.auth.SignInActivity
import id.research.apemapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mSplashBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mSplashBinding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val lanjut = Intent(this, SignInActivity::class.java)
            startActivity(lanjut)
            finish()
        }, 3000)
    }
}
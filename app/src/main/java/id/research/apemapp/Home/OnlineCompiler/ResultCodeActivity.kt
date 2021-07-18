package id.research.apemapp.Home.OnlineCompiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityResultCodeBinding

class ResultCodeActivity : AppCompatActivity() {

    private lateinit var resultCodeBinding: ActivityResultCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultCodeBinding = ActivityResultCodeBinding.inflate(layoutInflater)
        setContentView(resultCodeBinding.root)

        resultCodeBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, OnlineCompilerActivity::class.java))
            finish()
        }
    }
}
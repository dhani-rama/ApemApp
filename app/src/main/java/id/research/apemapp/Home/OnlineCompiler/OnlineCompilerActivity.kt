package id.research.apemapp.Home.OnlineCompiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityOnlineCompilerBinding

class OnlineCompilerActivity : AppCompatActivity() {

    private lateinit var onlineCompilerBinding: ActivityOnlineCompilerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onlineCompilerBinding = ActivityOnlineCompilerBinding.inflate(layoutInflater)
        setContentView(onlineCompilerBinding.root)

        setSupportActionBar(onlineCompilerBinding.toolbarEditor)

        supportActionBar?.setTitle("Compiler Online A-PEM")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onlineCompilerBinding.btnCheck.setOnClickListener {
            startActivity(Intent(this, ResultCodeActivity::class.java))
            finish()
        }
    }
}
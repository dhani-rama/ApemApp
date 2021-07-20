package id.research.apemapp.home.OnlineCompiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityResultCodeBinding

class ResultCodeActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_OUTPUT = "output"
        const val EXTRA_STATUS = "status_code"
        const val EXTRA_MEMORY = "memory"
        const val EXTRA_CPU = "cpu_time"
    }

    private lateinit var resultCodeBinding: ActivityResultCodeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultCodeBinding = ActivityResultCodeBinding.inflate(layoutInflater)
        setContentView(resultCodeBinding.root)

        resultCodeBinding.tvOutput.text = intent.getStringExtra(EXTRA_OUTPUT)
//        resultCodeBinding.tvStatus.text = intent.getStringExtra(EXTRA_STATUS)
        resultCodeBinding.tvMemory.text = intent.getStringExtra(EXTRA_MEMORY)
        resultCodeBinding.tvCpuTime.text = intent.getStringExtra(EXTRA_CPU)

        resultCodeBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, OnlineCompilerActivity::class.java))
            finish()
        }
    }
}
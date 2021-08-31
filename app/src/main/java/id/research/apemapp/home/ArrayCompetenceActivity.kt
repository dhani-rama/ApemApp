package id.research.apemapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArrayCompetenceBinding

class ArrayCompetenceActivity : AppCompatActivity() {

    private lateinit var mArrayCompetenceBinding: ActivityArrayCompetenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArrayCompetenceBinding = ActivityArrayCompetenceBinding.inflate(layoutInflater)
        setContentView(mArrayCompetenceBinding.root)

        mArrayCompetenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}
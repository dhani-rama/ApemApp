package id.research.apemapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityLoopingCompetenceBinding

class LoopingCompetenceActivity : AppCompatActivity() {

    private lateinit var mLoopingComptenceBinding: ActivityLoopingCompetenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoopingComptenceBinding = ActivityLoopingCompetenceBinding.inflate(layoutInflater)
        setContentView(mLoopingComptenceBinding.root)

        mLoopingComptenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}
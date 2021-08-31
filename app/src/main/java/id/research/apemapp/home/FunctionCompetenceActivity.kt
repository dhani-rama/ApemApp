package id.research.apemapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFunctionCompetenceBinding

class FunctionCompetenceActivity : AppCompatActivity() {

    private lateinit var mFunctionCompetenceBinding: ActivityFunctionCompetenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionCompetenceBinding = ActivityFunctionCompetenceBinding.inflate(layoutInflater)
        setContentView(mFunctionCompetenceBinding.root)

        mFunctionCompetenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}
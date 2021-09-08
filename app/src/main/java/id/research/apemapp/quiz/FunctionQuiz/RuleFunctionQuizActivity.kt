package id.research.apemapp.quiz.FunctionQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleFunctionQuizBinding

class RuleFunctionQuizActivity : AppCompatActivity() {

    private lateinit var mRuleFunctionBinding: ActivityRuleFunctionQuizBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleFunctionBinding = ActivityRuleFunctionQuizBinding.inflate(layoutInflater)
        setContentView(mRuleFunctionBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mRuleFunctionBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionQuizListActivity::class.java))
            finish()
        }

    }
}
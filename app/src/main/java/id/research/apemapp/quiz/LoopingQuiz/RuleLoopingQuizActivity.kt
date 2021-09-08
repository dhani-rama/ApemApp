package id.research.apemapp.quiz.LoopingQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleLoopingQuizBinding

class RuleLoopingQuizActivity : AppCompatActivity() {

    private lateinit var mRuleLoopingBinding: ActivityRuleLoopingQuizBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleLoopingBinding = ActivityRuleLoopingQuizBinding.inflate(layoutInflater)
        setContentView(mRuleLoopingBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mRuleLoopingBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleLoopingBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingQuizListActivity::class.java))
            finish()
        }

    }
}
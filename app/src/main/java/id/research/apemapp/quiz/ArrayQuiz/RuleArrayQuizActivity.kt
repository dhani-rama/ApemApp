package id.research.apemapp.quiz.ArrayQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleArrayQuizBinding

class RuleArrayQuizActivity : AppCompatActivity() {

    private lateinit var mRuleArrayQuizBinding: ActivityRuleArrayQuizBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleArrayQuizBinding = ActivityRuleArrayQuizBinding.inflate(layoutInflater)
        setContentView(mRuleArrayQuizBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mRuleArrayQuizBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleArrayQuizBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayQuizListActivity::class.java))
            finish()
        }
    }
}
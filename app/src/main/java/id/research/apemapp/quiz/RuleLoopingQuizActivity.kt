package id.research.apemapp.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleLoopingQuizBinding

class RuleLoopingQuizActivity : AppCompatActivity() {

    private lateinit var mRuleLoopingBinding: ActivityRuleLoopingQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleLoopingBinding = ActivityRuleLoopingQuizBinding.inflate(layoutInflater)
        setContentView(mRuleLoopingBinding.root)

        mRuleLoopingBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleLoopingBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, LoopingQuizListActivity::class.java))
            finish()
        }

    }
}
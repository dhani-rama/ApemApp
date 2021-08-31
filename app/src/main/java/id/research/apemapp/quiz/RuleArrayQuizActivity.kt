package id.research.apemapp.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleArrayQuizBinding

class RuleArrayQuizActivity : AppCompatActivity() {

    private lateinit var mRuleArrayQuizBinding: ActivityRuleArrayQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleArrayQuizBinding = ActivityRuleArrayQuizBinding.inflate(layoutInflater)
        setContentView(mRuleArrayQuizBinding.root)

        mRuleArrayQuizBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleArrayQuizBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayQuizListActivity::class.java))
            finish()
        }
    }
}
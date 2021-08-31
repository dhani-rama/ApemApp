package id.research.apemapp.quiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityRuleFunctionQuizBinding

class RuleFunctionQuizActivity : AppCompatActivity() {

    private lateinit var mRuleFunctionBinding: ActivityRuleFunctionQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRuleFunctionBinding = ActivityRuleFunctionQuizBinding.inflate(layoutInflater)
        setContentView(mRuleFunctionBinding.root)

        mRuleFunctionBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mRuleFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionQuizListActivity::class.java))
            finish()
        }

    }
}
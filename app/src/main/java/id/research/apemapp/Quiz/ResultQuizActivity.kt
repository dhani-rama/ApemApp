package id.research.apemapp.Quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityResultQuizBinding
import id.research.apemapp.util.Constants
import id.research.apemapp.util.MySharedPreferences

class ResultQuizActivity : AppCompatActivity() {

    private lateinit var resultQuizBinding: ActivityResultQuizBinding
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var studentId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resultQuizBinding = ActivityResultQuizBinding.inflate(layoutInflater)
        setContentView(resultQuizBinding.root)

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        resultQuizBinding.tvScoreQuiz.text = intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

        reward()


        resultQuizBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

    }

    private fun reward(){

        val rewardValue = intent.getIntExtra(Constants.STUDENT_LOOPING_QUIZ_SCORE, 0)

        with(resultQuizBinding){
            tvCongratulations.visibility = View.GONE
            tvNeverGiveUp.visibility = View.GONE
            imgCongratulation.visibility = View.GONE
            imgFailure.visibility = View.GONE
        }

        if(rewardValue < 15){
            with(resultQuizBinding){
                tvNeverGiveUp.visibility = View.VISIBLE
                imgFailure.visibility = View.VISIBLE
            }
        }
        else{
            with(resultQuizBinding){
                tvCongratulations.visibility = View.VISIBLE
                imgCongratulation.visibility = View.VISIBLE
            }
        }
    }
}
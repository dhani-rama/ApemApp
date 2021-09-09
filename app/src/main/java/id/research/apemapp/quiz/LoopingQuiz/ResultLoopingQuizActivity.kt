package id.research.apemapp.quiz.LoopingQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityResultLoopingQuizBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.objects.Constants
import id.research.apemapp.utils.MySharedPreferences

class ResultLoopingQuizActivity : AppCompatActivity() {

    private lateinit var mResultLoopingBinding: ActivityResultLoopingQuizBinding
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var studentId: String

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mResultLoopingBinding = ActivityResultLoopingQuizBinding.inflate(layoutInflater)
        setContentView(mResultLoopingBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mResultLoopingBinding.tvScoreQuiz.text = intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

        achievement()

    }

    private fun achievement() {
        val score = intent.getIntExtra(Constants.STUDENT_LOOPING_QUIZ_SCORE, 0)

        with(mResultLoopingBinding) {
            imgCongratulation.visibility = View.GONE
            tvCongratulations.visibility = View.GONE
            tvFirstCongratulation.visibility = View.GONE
            tvSecondCongratulation.visibility = View.GONE
            tvThirdCongratulation.visibility = View.GONE
            btnBackCongratulation.visibility = View.GONE
            imgFailure.visibility = View.GONE
            tvNeverGiveUp.visibility = View.GONE
            tvFirstNeverGiveUp.visibility = View.GONE
            tvSecondNeverGiveUp.visibility = View.GONE
            tvThirdNeverGiveUp.visibility = View.GONE
            tvFourthNeverGiveUp.visibility = View.GONE
            btnBackMaterials.visibility = View.GONE
            btnBackNeverGiveUp.visibility = View.GONE

        }

        if (score < 70) {
            with(mResultLoopingBinding) {
                tvNeverGiveUp.visibility = View.VISIBLE
                tvFirstNeverGiveUp.visibility = View.VISIBLE
                tvSecondNeverGiveUp.visibility = View.VISIBLE
                tvThirdNeverGiveUp.visibility = View.VISIBLE
                tvFourthNeverGiveUp.visibility = View.VISIBLE
                btnBackMaterials.visibility = View.VISIBLE
                btnBackNeverGiveUp.visibility = View.VISIBLE
                imgFailure.visibility = View.VISIBLE

                tvSecondNeverGiveUp.text = intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)
                btnBackMaterials.setOnClickListener {
                    startActivity(
                        Intent(
                            this@ResultLoopingQuizActivity,
                            LoopingDetailMaterialsActivity::class.java
                        )
                    )
                }

                btnBackNeverGiveUp.setOnClickListener {
                    startActivity(Intent(this@ResultLoopingQuizActivity, HomeActivity::class.java))
                }
            }
        } else {
            with(mResultLoopingBinding) {
                imgCongratulation.visibility = View.VISIBLE
                tvCongratulations.visibility = View.VISIBLE
                tvFirstCongratulation.visibility = View.VISIBLE
                tvSecondCongratulation.visibility = View.VISIBLE
                tvThirdCongratulation.visibility = View.VISIBLE
                btnBackCongratulation.visibility = View.VISIBLE

                tvSecondCongratulation.text = intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

                btnBackCongratulation.setOnClickListener {
                    startActivity(Intent(this@ResultLoopingQuizActivity, HomeActivity::class.java))
                }
            }
        }
    }
}
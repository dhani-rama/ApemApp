package id.research.apemapp.quiz.ArrayQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityResultArrayQuizBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class ResultArrayQuizActivity : AppCompatActivity() {

    private lateinit var mResultArrayBinding: ActivityResultArrayQuizBinding
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var studentId: String

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mResultArrayBinding = ActivityResultArrayQuizBinding.inflate(layoutInflater)
        setContentView(mResultArrayBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mResultArrayBinding.tvScoreQuiz.text =
            intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

        achievement()
    }

    private fun achievement() {
        val score = intent.getIntExtra(Constants.STUDENT_ARRAY_QUIZ_SCORE, 0)

        with(mResultArrayBinding) {
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
            with(mResultArrayBinding) {
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
                            this@ResultArrayQuizActivity, ArrayDetailMaterialsActivity::class.java
                        )
                    )
                }

                btnBackNeverGiveUp.setOnClickListener {
                    startActivity(Intent(this@ResultArrayQuizActivity, HomeActivity::class.java))
                }
            }
        } else {
            with(mResultArrayBinding) {
                imgCongratulation.visibility = View.VISIBLE
                tvCongratulations.visibility = View.VISIBLE
                tvFirstCongratulation.visibility = View.VISIBLE
                tvSecondCongratulation.visibility = View.VISIBLE
                tvThirdCongratulation.visibility = View.VISIBLE
                btnBackCongratulation.visibility = View.VISIBLE

                tvSecondCongratulation.text =
                    intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

                btnBackCongratulation.setOnClickListener {
                    startActivity(Intent(this@ResultArrayQuizActivity, HomeActivity::class.java))
                }
            }
        }
    }

}
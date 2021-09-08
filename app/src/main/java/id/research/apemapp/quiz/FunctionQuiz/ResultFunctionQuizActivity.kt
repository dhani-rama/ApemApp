package id.research.apemapp.quiz.FunctionQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityResultFunctionQuizBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences

class ResultFunctionQuizActivity : AppCompatActivity() {

    private lateinit var mResultFunctionBinding: ActivityResultFunctionQuizBinding
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var studentId: String

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mResultFunctionBinding = ActivityResultFunctionQuizBinding.inflate(layoutInflater)
        setContentView(mResultFunctionBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mResultFunctionBinding.tvScoreQuiz.text =
            intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

        achievement()

    }

    private fun achievement() {
        val score = intent.getIntExtra(Constants.STUDENT_FUNCTION_QUIZ_SCORE, 0)

        with(mResultFunctionBinding) {
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
            with(mResultFunctionBinding) {
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
                            this@ResultFunctionQuizActivity,
                            FunctionDetailMaterialsActivity::class.java
                        )
                    )
                }

                btnBackNeverGiveUp.setOnClickListener {
                    startActivity(
                        Intent(
                            this@ResultFunctionQuizActivity, HomeActivity::class.java
                        )
                    )
                }
            }
        } else {
            with(mResultFunctionBinding) {
                imgCongratulation.visibility = View.VISIBLE
                tvCongratulations.visibility = View.VISIBLE
                tvFirstCongratulation.visibility = View.VISIBLE
                tvSecondCongratulation.visibility = View.VISIBLE
                tvThirdCongratulation.visibility = View.VISIBLE
                btnBackCongratulation.visibility = View.VISIBLE

                tvSecondCongratulation.text =
                    intent.getStringExtra(Constants.STUDENT_FINAL_QUIZ_SCORE)

                btnBackCongratulation.setOnClickListener {
                    startActivity(
                        Intent(
                            this@ResultFunctionQuizActivity,
                            HomeActivity::class.java
                        )
                    )
                }
            }
        }
    }
}
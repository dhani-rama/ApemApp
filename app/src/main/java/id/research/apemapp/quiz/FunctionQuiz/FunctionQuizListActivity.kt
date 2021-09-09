package id.research.apemapp.quiz.FunctionQuiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityFunctionQuizListBinding
import id.research.apemapp.models.QuestionListEntity
import id.research.apemapp.objects.Constants
import id.research.apemapp.utils.MySharedPreferences

class FunctionQuizListActivity : AppCompatActivity() {

    private lateinit var mFunctionQuizBinding: ActivityFunctionQuizListBinding
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var mQuiz: ArrayList<QuestionListEntity>
    private lateinit var studentId: String
    var mCurrentPosition: Int = 1
    var answerIndex: Int = 0
    var mScore: Int = 0

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionQuizBinding = ActivityFunctionQuizListBinding.inflate(layoutInflater)
        setContentView(mFunctionQuizBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mQuiz = arrayListOf<QuestionListEntity>()

        updateQuestion()

    }

    private fun updateQuestion() {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("questionsFunction")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val collection = item.getValue(QuestionListEntity::class.java)
                        mQuiz.add(collection!!)
                    }

                    setQuestion()

                    mFunctionQuizBinding.btnNext.setOnClickListener {
                        if (mFunctionQuizBinding.rbFirstAnswer.isChecked || mFunctionQuizBinding.rbSecondAnswer.isChecked ||
                            mFunctionQuizBinding.rbThirdAnswer.isChecked || mFunctionQuizBinding.rbFourthAnswer.isChecked ||
                            mFunctionQuizBinding.rbFifthAnswer.isChecked
                        ) {
                            mCurrentPosition++
                            setQuestion()
                            answerIndex++
                        } else {
                            Toasty.error(
                                this@FunctionQuizListActivity,
                                "Jawaban Belum Anda Pilih",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }

                    mFunctionQuizBinding.btnFinish.setOnClickListener {
                        if (mFunctionQuizBinding.rbFirstAnswer.isChecked || mFunctionQuizBinding.rbSecondAnswer.isChecked ||
                            mFunctionQuizBinding.rbThirdAnswer.isChecked || mFunctionQuizBinding.rbFourthAnswer.isChecked ||
                            mFunctionQuizBinding.rbFifthAnswer.isChecked
                        ) {
                            setQuestion()

                            mDatabase = FirebaseDatabase.getInstance().getReference("Student")
                            mDatabase.child(studentId).child("function_quiz_score")
                                .setValue(mScore.toString())

                            val intent =
                                Intent(
                                    this@FunctionQuizListActivity,
                                    ResultFunctionQuizActivity::class.java
                                )
                                    .apply {
                                        putExtra(
                                            Constants.STUDENT_FINAL_QUIZ_SCORE,
                                            mScore.toString()
                                        )
                                        putExtra(Constants.STUDENT_FUNCTION_QUIZ_SCORE, mScore)
                                    }
                            startActivity(intent)
                            finish()
                        } else {
                            Toasty.error(
                                this@FunctionQuizListActivity,
                                "Jawaban Belum Anda Pilih",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun setQuestion() {
        with(mFunctionQuizBinding) {
            btnNext.visibility = View.GONE
            btnFinish.visibility = View.GONE
        }

        if (mCurrentPosition == mQuiz.size) {
            mFunctionQuizBinding.btnFinish.visibility = View.VISIBLE
        } else {
            mFunctionQuizBinding.btnNext.visibility = View.VISIBLE
        }

        val question = mQuiz[mCurrentPosition - 1]

        if (mFunctionQuizBinding.rbFirstAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", mFunctionQuizBinding.rbFirstAnswer.text as String)

            if (mFunctionQuizBinding.rbFirstAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (mFunctionQuizBinding.rbSecondAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", mFunctionQuizBinding.rbSecondAnswer.text as String)

            if (mFunctionQuizBinding.rbSecondAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (mFunctionQuizBinding.rbThirdAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", mFunctionQuizBinding.rbThirdAnswer.text as String)

            if (mFunctionQuizBinding.rbThirdAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (mFunctionQuizBinding.rbFourthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", mFunctionQuizBinding.rbFourthAnswer.text as String)

            if (mFunctionQuizBinding.rbFourthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (mFunctionQuizBinding.rbFifthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", mFunctionQuizBinding.rbFifthAnswer.text as String)

            if (mFunctionQuizBinding.rbFifthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else {
            Log.d("ERROR", "Tidak Ada Jawaban yang dipilih")
        }

        with(mFunctionQuizBinding) {
            tvNumberQuestion.text = "$mCurrentPosition"
            tvQuestion.text = question.Question
            rbFirstAnswer.text = question.OptionA
            rbSecondAnswer.text = question.OptionB
            rbThirdAnswer.text = question.OptionC
            rbFourthAnswer.text = question.OptionD
            rbFifthAnswer.text = question.OptionE
            radioGroupAnswer.clearCheck()
        }
    }
}
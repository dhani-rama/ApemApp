package id.research.apemapp.quiz.LoopingQuiz

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
import id.research.apemapp.databinding.ActivityLoopingQuizListBinding
import id.research.apemapp.models.QuestionListEntity
import id.research.apemapp.quiz.ResultQuizActivity
import id.research.apemapp.utils.Constants
import id.research.apemapp.utils.MySharedPreferences


class LoopingQuizListActivity : AppCompatActivity() {

    private lateinit var quizBinding: ActivityLoopingQuizListBinding
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
        quizBinding = ActivityLoopingQuizListBinding.inflate(layoutInflater)
        setContentView(quizBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mQuiz = arrayListOf<QuestionListEntity>()


        updateQuestion()

    }

    private fun updateQuestion() {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("questionsLooping")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val collection = item.getValue(QuestionListEntity::class.java)
                        mQuiz.add(collection!!)
                    }

                    setQuestion()

                    quizBinding.btnNext.setOnClickListener {
                        if (quizBinding.rbFirstAnswer.isChecked || quizBinding.rbSecondAnswer.isChecked ||
                            quizBinding.rbThirdAnswer.isChecked || quizBinding.rbFourthAnswer.isChecked ||
                            quizBinding.rbFifthAnswer.isChecked
                        ) {

                            mCurrentPosition++
                            setQuestion()
                            answerIndex++
                        } else {
                            Toasty.error(
                                this@LoopingQuizListActivity,
                                "Jawaban Belum Anda Pilih",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }

                    quizBinding.btnFinish.setOnClickListener {

                        if (quizBinding.rbFirstAnswer.isChecked || quizBinding.rbSecondAnswer.isChecked ||
                            quizBinding.rbThirdAnswer.isChecked || quizBinding.rbFourthAnswer.isChecked ||
                            quizBinding.rbFifthAnswer.isChecked
                        ) {

                            setQuestion()


                            mDatabase = FirebaseDatabase.getInstance().getReference("Student")
                            mDatabase.child(studentId).child("looping_quiz_score")
                                .setValue(mScore.toString())

                            val intent =
                                Intent(
                                    this@LoopingQuizListActivity,
                                    ResultLoopingQuizActivity::class.java
                                )
                                    .apply {
                                        putExtra(
                                            Constants.STUDENT_FINAL_QUIZ_SCORE,
                                            mScore.toString()
                                        )
                                        putExtra(
                                            Constants.STUDENT_LOOPING_QUIZ_SCORE,
                                            mScore
                                        )
                                    }
                            startActivity(intent)
                            finish()

                        } else {
                            Toasty.error(
                                this@LoopingQuizListActivity,
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

        with(quizBinding) {
            btnNext.visibility = View.GONE
            btnFinish.visibility = View.GONE
        }

        if (mCurrentPosition == mQuiz.size) {
            quizBinding.btnFinish.visibility = View.VISIBLE
        } else {
            quizBinding.btnNext.visibility = View.VISIBLE
        }

        val question = mQuiz[mCurrentPosition - 1]

        if (quizBinding.rbFirstAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", quizBinding.rbFirstAnswer.text as String)
            if (quizBinding.rbFirstAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (quizBinding.rbSecondAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", quizBinding.rbSecondAnswer.text as String)
            if (quizBinding.rbSecondAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (quizBinding.rbThirdAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", quizBinding.rbThirdAnswer.text as String)
            if (quizBinding.rbThirdAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (quizBinding.rbFourthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", quizBinding.rbFourthAnswer.text as String)
            if (quizBinding.rbFourthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (quizBinding.rbFifthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", quizBinding.rbFifthAnswer.text as String)
            if (quizBinding.rbFifthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else {
            Log.d("ERROR", "Tidak Ada Jawaban yang dipilih")
        }

        with(quizBinding) {
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

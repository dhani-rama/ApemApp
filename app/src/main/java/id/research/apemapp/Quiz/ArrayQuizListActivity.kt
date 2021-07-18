package id.research.apemapp.Quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import id.research.apemapp.Models.QuestionListEntity
import id.research.apemapp.databinding.ActivityArrayQuizListBinding
import id.research.apemapp.util.Constants
import id.research.apemapp.util.MySharedPreferences

class ArrayQuizListActivity : AppCompatActivity() {

    private lateinit var arrayQuizListBinding: ActivityArrayQuizListBinding
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var mQuiz: ArrayList<QuestionListEntity>
    private lateinit var studentId: String
    var mCurrentPosition: Int = 1
    var answerIndex: Int = 0
    var mScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayQuizListBinding = ActivityArrayQuizListBinding.inflate(layoutInflater)
        setContentView(arrayQuizListBinding.root)

        mySharedPreferences = MySharedPreferences(this)
        studentId = mySharedPreferences.getValue(Constants.STUDENT_ID)!!

        mQuiz = arrayListOf<QuestionListEntity>()

        updateQuestion()

    }

    private fun updateQuestion() {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("ArrayQuestions")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val collection = item.getValue(QuestionListEntity::class.java)
                        mQuiz.add(collection!!)
                    }

                    setQuestion()

                    arrayQuizListBinding.btnNext.setOnClickListener {
                        if (arrayQuizListBinding.rbFirstAnswer.isChecked || arrayQuizListBinding.rbSecondAnswer.isChecked ||
                            arrayQuizListBinding.rbThirdAnswer.isChecked || arrayQuizListBinding.rbFourthAnswer.isChecked ||
                            arrayQuizListBinding.rbFifthAnswer.isChecked
                        ) {
                            mCurrentPosition++
                            setQuestion()
                            answerIndex++
                        } else {
                            Toasty.error(this@ArrayQuizListActivity, "Jawaban belum anda pilih", Toast.LENGTH_SHORT).show()

//                            Toast.makeText(
//                                this@ArrayQuizListActivity,
//                                "Mohon isi jawabannya terlebih dahulu",
//                                Toast.LENGTH_SHORT
//                            ).show()
                        }
                    }

                    arrayQuizListBinding.btnFinish.setOnClickListener {

                        if (arrayQuizListBinding.rbFirstAnswer.isChecked || arrayQuizListBinding.rbSecondAnswer.isChecked ||
                            arrayQuizListBinding.rbThirdAnswer.isChecked || arrayQuizListBinding.rbFourthAnswer.isChecked ||
                            arrayQuizListBinding.rbFifthAnswer.isChecked
                        ) {
                            setQuestion()

                            mDatabase = FirebaseDatabase.getInstance().getReference("Student")
                            mDatabase.child(studentId).child("array_quiz_score")
                                .setValue(mScore.toString())

                            val intent =
                                Intent(this@ArrayQuizListActivity, ResultQuizActivity::class.java)
                                    .apply {
                                        putExtra(
                                            Constants.STUDENT_FINAL_QUIZ_SCORE,
                                            mScore.toString()
                                        )
                                        putExtra(Constants.STUDENT_LOOPING_QUIZ_SCORE, mScore)
                                    }
                            startActivity(intent)
                            finish()
                        } else {
                            Toasty.error(this@ArrayQuizListActivity, "Jawaban belum anda pilih", Toast.LENGTH_SHORT).show()
//                            Toast.makeText(
//                                this@ArrayQuizListActivity,
//                                "Mohon isi jawabannya terlebih dahulu",
//                                Toast.LENGTH_SHORT
//                            ).show()
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
        with(arrayQuizListBinding) {
            btnNext.visibility = View.GONE
            btnFinish.visibility = View.GONE
        }

        if (mCurrentPosition == mQuiz.size) {
            arrayQuizListBinding.btnFinish.visibility = View.VISIBLE
        } else {
            arrayQuizListBinding.btnNext.visibility = View.VISIBLE
        }

        val question = mQuiz[mCurrentPosition - 1]

        if (arrayQuizListBinding.rbFirstAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", arrayQuizListBinding.rbFirstAnswer.text as String)

            if (arrayQuizListBinding.rbFirstAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (arrayQuizListBinding.rbSecondAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", arrayQuizListBinding.rbSecondAnswer.text as String)

            if (arrayQuizListBinding.rbSecondAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (arrayQuizListBinding.rbThirdAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", arrayQuizListBinding.rbThirdAnswer.text as String)

            if (arrayQuizListBinding.rbThirdAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (arrayQuizListBinding.rbFourthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", arrayQuizListBinding.rbFourthAnswer.text as String)

            if (arrayQuizListBinding.rbFourthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else if (arrayQuizListBinding.rbFifthAnswer.isChecked() == true) {
            Log.d("Kunci Jawaban =", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Jawaban =", arrayQuizListBinding.rbFifthAnswer.text as String)

            if (arrayQuizListBinding.rbFifthAnswer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "Salah")
            } else {
                Log.d("Sukses", "Benar")
                mScore = this.mScore + 5
            }
        } else {
            Log.d("ERROR", "Tidak Ada Jawaban yang dipilih")
        }

        with(arrayQuizListBinding) {
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
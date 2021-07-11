package id.research.apemapp.Quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.database.*
import id.research.apemapp.Models.QuestionListEntity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityQuizListBinding
import id.research.apemapp.util.MySharedPreferences
import kotlinx.android.synthetic.main.activity_quiz_list.*


class QuizListActivity : AppCompatActivity() {

    private lateinit var quizBinding: ActivityQuizListBinding
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mySharedPreferences: MySharedPreferences
    private lateinit var mQuiz: ArrayList<QuestionListEntity>
    var mCurrentPosition: Int = 1
    var answerIndex: Int = 0
    var score: Int = 0
    var mScore: Int = 0
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizBinding = ActivityQuizListBinding.inflate(layoutInflater)
        setContentView(quizBinding.root)

        mQuiz = arrayListOf<QuestionListEntity>()


        updateQuestion()

    }

    private fun updateQuestion() {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Questions")

        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (item in snapshot.children) {
                        val collection = item.getValue(QuestionListEntity::class.java)
                        mQuiz.add(collection!!)
                    }

                    setQuestion()

                    quizBinding.btnNext.setOnClickListener {
                        mCurrentPosition++
                        setQuestion()
                        answerIndex++
                    }

                    quizBinding.btnFinish.setOnClickListener {
                        setQuestion()
                        Toast.makeText(
                            this@QuizListActivity,
                            "Selamat Anda Sudah Menyelesaikan Quiz NILAI SKOR = " + mScore.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        val intent = Intent(this@QuizListActivity, ResultQuizActivity::class.java)
                        startActivity(intent)
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

        if (rb_first_answer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", rb_first_answer.text as String)
            if (rb_first_answer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (rb_second_answer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", rb_second_answer.text as String)
            if (rb_second_answer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (rb_third_answer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", rb_third_answer.text as String)
            if (rb_third_answer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (rb_fourth_answer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", rb_fourth_answer.text as String)
            if (rb_fourth_answer.text != mQuiz[answerIndex].Answer) {
                Log.d("Gagal", "salah")
            } else {
                Log.d("Sukses", "benar")
                mScore = this.mScore + 5
            }
        } else if (rb_fifth_answer.isChecked() == true) {
            Log.d("Kunci Jawaban = ", mQuiz[answerIndex].Answer)
            Log.d("Jawaban Anda = ", rb_fifth_answer.text as String)
            if (rb_fifth_answer.text != mQuiz[answerIndex].Answer) {
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

package id.research.apemapp.Quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityResultQuizBinding

class ResultQuizActivity : AppCompatActivity() {

    private lateinit var resultQuizBinding: ActivityResultQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resultQuizBinding = ActivityResultQuizBinding.inflate(layoutInflater)
        setContentView(resultQuizBinding.root)


    }
}
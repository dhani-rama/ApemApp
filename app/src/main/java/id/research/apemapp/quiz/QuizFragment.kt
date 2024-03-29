package id.research.apemapp.quiz


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.research.apemapp.databinding.FragmentQuizBinding
import id.research.apemapp.quiz.ArrayQuiz.RuleArrayQuizActivity
import id.research.apemapp.quiz.FunctionQuiz.RuleFunctionQuizActivity
import id.research.apemapp.quiz.LoopingQuiz.RuleLoopingQuizActivity

class QuizFragment : Fragment() {

    private lateinit var quizBinding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        quizBinding = FragmentQuizBinding.inflate(inflater, container, false)
        return quizBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        quizBinding.cardLooping.setOnClickListener {
            startActivity(Intent(this.requireActivity(), RuleLoopingQuizActivity::class.java))
        }

        quizBinding.cardArray.setOnClickListener {
            startActivity(Intent(this.requireActivity(), RuleArrayQuizActivity::class.java))
        }

        quizBinding.cardFunction.setOnClickListener {
            startActivity(Intent(this.requireActivity(), RuleFunctionQuizActivity::class.java))
//            activity?.finish()
        }
    }
}
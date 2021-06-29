package id.research.apemapp.Quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.research.apemapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private lateinit var quizBinding : FragmentQuizBinding

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
    }

}
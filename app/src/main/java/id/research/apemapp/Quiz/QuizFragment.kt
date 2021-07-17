package id.research.apemapp.Quiz


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import id.research.apemapp.R
import id.research.apemapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private lateinit var quizBinding: FragmentQuizBinding
    var WrapInScrollView: Boolean = true

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




        quizBinding.cardArray.setOnClickListener {

            startActivity(Intent(this.requireContext(), LoopingQuizListActivity::class.java ))
            activity?.finish()

        }

        quizBinding.cardFunction.setOnClickListener {
            startActivity(Intent(this.requireContext(), ArrayQuizListActivity::class.java ))
            activity?.finish()
        }
    }
}
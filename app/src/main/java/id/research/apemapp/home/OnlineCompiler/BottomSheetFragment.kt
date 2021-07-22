package id.research.apemapp.home.OnlineCompiler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.research.apemapp.databinding.FragmentBottomSheetBinding


class BottomSheetFragment : BottomSheetDialogFragment() {

    companion object{
        const val EXTRA_OUTPUT = "output"
        const val EXTRA_MEMORY = "memory"
        const val EXTRA_CPU = "cpu_time"
    }

    private lateinit var bottomSheetBinding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bottomSheetBinding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return bottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(bottomSheetBinding){
            tvOutput.text = arguments?.getString(EXTRA_OUTPUT)
            tvMemory.text = arguments?.getString(EXTRA_MEMORY)
            tvCpuTime.text = arguments?.getString(EXTRA_CPU)
        }
    }
}
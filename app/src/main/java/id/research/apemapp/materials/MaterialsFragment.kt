package id.research.apemapp.materials

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.research.apemapp.databinding.FragmentMaterialsBinding


class MaterialsFragment: Fragment() {

    private lateinit var materialsBinding : FragmentMaterialsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        materialsBinding = FragmentMaterialsBinding.inflate(inflater, container, false)
        return materialsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
package id.research.apemapp.materials

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.FragmentMaterialsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity


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

        materialsBinding.cardArray.setOnClickListener {
            startActivity(Intent(this.requireActivity(), ArrayDetailMaterialsActivity::class.java))
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
        }

        materialsBinding.cardFungsi.setOnClickListener {
            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG)
                .show()
        }

        materialsBinding.cardLooping.setOnClickListener {
            startActivity(
                Intent(
                    this.requireActivity(),
                    LoopingDetailMaterialsActivity::class.java
                )
            )
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG)
//                .show()
        }
    }

}
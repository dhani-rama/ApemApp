package id.research.apemapp.materials

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.research.apemapp.R
import id.research.apemapp.databinding.FragmentMaterialsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel


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


        firstImageSlider()

        materialsBinding.cardArray.setOnClickListener {
            startActivity(Intent(this.requireActivity(), ArrayDetailMaterialsActivity::class.java))
//            Toasty.info(this.requireActivity(), "Belum Aku Coding Sayang :)", Toast.LENGTH_LONG).show()
        }

        materialsBinding.cardFungsi.setOnClickListener {
            startActivity(
                Intent(
                    this.requireActivity(),
                    FunctionDetailMaterialsActivity::class.java
                )
            )
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

    private fun firstImageSlider() {
        val firstCarousel: ImageCarousel = requireView().findViewById(R.id.carousel_view_first)
        val firstList = mutableListOf<CarouselItem>()

        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_kemdikbud))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_vocational))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_vocational))

        firstCarousel.addData(firstList)
    }

}
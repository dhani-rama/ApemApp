package id.research.apemapp.materials.ArrayMaterials

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityArrayDetailMaterialsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial.ArrayConceptGoalActivity
import id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial.ArrayFirstDimensionGoalsActivity
import id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial.ArraySecondDimensionGoalsActivity
import id.research.apemapp.materials.ArrayMaterials.ThirdArrayDimensionMaterial.ArrayThirdDimensionGoalsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class ArrayDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mArrayDetailMaterialsBinding: ActivityArrayDetailMaterialsBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mArrayDetailMaterialsBinding = ActivityArrayDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mArrayDetailMaterialsBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        firstImageSlider()

        mArrayDetailMaterialsBinding.btnBack.setOnClickListener {
            onBackPressed()
        }
        mArrayDetailMaterialsBinding.cardArrayConcept.setOnClickListener {
            startActivity(Intent(this, ArrayConceptGoalActivity::class.java))
        }
        mArrayDetailMaterialsBinding.cardFirstArray.setOnClickListener {
            startActivity(Intent(this, ArrayFirstDimensionGoalsActivity::class.java))
        }
        mArrayDetailMaterialsBinding.cardSecondArray.setOnClickListener {
            startActivity(Intent(this, ArraySecondDimensionGoalsActivity::class.java))
        }
        mArrayDetailMaterialsBinding.cardThirdArray.setOnClickListener {
            startActivity(Intent(this, ArrayThirdDimensionGoalsActivity::class.java))
        }

    }

    private fun firstImageSlider() {
        val firstCarousel: ImageCarousel = findViewById(R.id.carousel_view_first)
        val firstList = mutableListOf<CarouselItem>()

        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_kemdikbud))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_vocational))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_vocational))

        firstCarousel.addData(firstList)
    }
}
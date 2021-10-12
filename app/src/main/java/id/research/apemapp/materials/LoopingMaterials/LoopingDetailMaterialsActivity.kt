package id.research.apemapp.materials.LoopingMaterials

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityLoopingDetailMaterialsBinding
import id.research.apemapp.materials.LoopingMaterials.ForMaterial.ForLearningGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial.LoopingConceptGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.NestedForMaterial.NestedForLearningGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.WhileMaterial.WhileLearningGoalsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class LoopingDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mLoopingDetailBinding: ActivityLoopingDetailMaterialsBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoopingDetailBinding = ActivityLoopingDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mLoopingDetailBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        firstImageSlider()

        mLoopingDetailBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mLoopingDetailBinding.cardLoopingConcept.setOnClickListener {
            startActivity(Intent(this, LoopingConceptGoalsActivity::class.java))
        }

        mLoopingDetailBinding.cardLoopingFor.setOnClickListener {
            startActivity(Intent(this, ForLearningGoalsActivity::class.java))
        }

        mLoopingDetailBinding.cardLoopingWhile.setOnClickListener {
            startActivity(Intent(this, WhileLearningGoalsActivity::class.java))
        }

        mLoopingDetailBinding.cardLoopingNested.setOnClickListener {
            startActivity(Intent(this, NestedForLearningGoalsActivity::class.java))
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
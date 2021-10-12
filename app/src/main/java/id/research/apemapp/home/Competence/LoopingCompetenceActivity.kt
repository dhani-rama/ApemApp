package id.research.apemapp.home.Competence

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityLoopingCompetenceBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class LoopingCompetenceActivity : AppCompatActivity() {

    private lateinit var mLoopingComptenceBinding: ActivityLoopingCompetenceBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoopingComptenceBinding = ActivityLoopingCompetenceBinding.inflate(layoutInflater)
        setContentView(mLoopingComptenceBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        firstImageSlider()

        mLoopingComptenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mLoopingComptenceBinding.btnNextLooping.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
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
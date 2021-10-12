package id.research.apemapp.home.Competence

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityArrayCompetenceBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class ArrayCompetenceActivity : AppCompatActivity() {

    private lateinit var mArrayCompetenceBinding: ActivityArrayCompetenceBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArrayCompetenceBinding = ActivityArrayCompetenceBinding.inflate(layoutInflater)
        setContentView(mArrayCompetenceBinding.root)

        firstImageSlider()

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mArrayCompetenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mArrayCompetenceBinding.btnNextArray.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
//            onBackPressed()
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
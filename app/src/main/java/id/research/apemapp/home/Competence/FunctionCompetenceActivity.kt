package id.research.apemapp.home.Competence

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityFunctionCompetenceBinding
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class FunctionCompetenceActivity : AppCompatActivity() {

    private lateinit var mFunctionCompetenceBinding: ActivityFunctionCompetenceBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionCompetenceBinding = ActivityFunctionCompetenceBinding.inflate(layoutInflater)
        setContentView(mFunctionCompetenceBinding.root)

        firstImageSlider()

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mFunctionCompetenceBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun firstImageSlider() {
        val firstCarousel: ImageCarousel = findViewById(R.id.carousel_view_first)
        val firstList = mutableListOf<CarouselItem>()

        firstList.add(CarouselItem(imageDrawable = R.drawable.img_logo_kemdikbud))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_um))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_first_logo_vocational))
        firstList.add(CarouselItem(imageDrawable = R.drawable.img_second_logo_vocational))

        firstCarousel.addData(firstList)
    }
}
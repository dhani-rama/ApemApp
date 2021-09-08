package id.research.apemapp.profile

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityDeveloperProfileBinding
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class DeveloperProfileActivity : AppCompatActivity() {

    private lateinit var mDeveloperProfileBinding: ActivityDeveloperProfileBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDeveloperProfileBinding = ActivityDeveloperProfileBinding.inflate(layoutInflater)
        setContentView(mDeveloperProfileBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        firstImageSlider()

        mDeveloperProfileBinding.btnBack.setOnClickListener {
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
package id.research.apemapp.dictionary

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityDictionaryDetailListBinding
import id.research.apemapp.utils.Constants
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class DictionaryDetailListActivity : AppCompatActivity() {

    private lateinit var dictionaryDetailListBinding: ActivityDictionaryDetailListBinding


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dictionaryDetailListBinding = ActivityDictionaryDetailListBinding.inflate(layoutInflater)
        setContentView(dictionaryDetailListBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        dictionaryDetailListBinding.btnBack.setOnClickListener{
            val intent = Intent(this@DictionaryDetailListActivity, DictionaryListActivity::class.java)
            startActivity(intent)
            finish()
        }

        firstImageSlider()

        dictionaryDetailListBinding.tvWord.text = intent.getStringExtra(Constants.EXTRA_WORD)
        dictionaryDetailListBinding.tvMeaning.text = intent.getStringExtra(Constants.EXTRA_MEANING)
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
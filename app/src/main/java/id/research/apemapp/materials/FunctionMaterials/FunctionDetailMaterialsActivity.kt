package id.research.apemapp.materials.FunctionMaterials

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityFunctionDetailMaterialsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial.FunctionConceptGoalsActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionFileHeaderMaterial.FileHeaderGoalsActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial.ParameterGoalsActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial.VariableGoalsActivity
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class FunctionDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mFunctionDetailBinding: ActivityFunctionDetailMaterialsBinding

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionDetailBinding = ActivityFunctionDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mFunctionDetailBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        firstImageSlider()

        mFunctionDetailBinding.btnBackFunction.setOnClickListener {
            onBackPressed()
        }

        mFunctionDetailBinding.cardFunctionConcept.setOnClickListener {
            startActivity(Intent(this, FunctionConceptGoalsActivity::class.java))
        }

        mFunctionDetailBinding.cardVariabelFunction.setOnClickListener {
            startActivity(Intent(this, VariableGoalsActivity::class.java))
        }

        mFunctionDetailBinding.cardFunctionParameter.setOnClickListener {
            startActivity(Intent(this, ParameterGoalsActivity::class.java))
        }

        mFunctionDetailBinding.cardHeaderFileFunction.setOnClickListener {
            startActivity(Intent(this, FileHeaderGoalsActivity::class.java))
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
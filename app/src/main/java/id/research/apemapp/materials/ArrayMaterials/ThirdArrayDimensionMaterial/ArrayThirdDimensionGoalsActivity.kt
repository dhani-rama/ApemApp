package id.research.apemapp.materials.ArrayMaterials.ThirdArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArrayThirdDimensionGoalsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class ArrayThirdDimensionGoalsActivity : AppCompatActivity() {

    private lateinit var mArrayThirdBinding: ActivityArrayThirdDimensionGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArrayThirdBinding = ActivityArrayThirdDimensionGoalsBinding.inflate(layoutInflater)
        setContentView(mArrayThirdBinding.root)

        mArrayThirdBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mArrayThirdBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstArrayThirdDimensionActivity::class.java))
            finish()
        }

    }
}
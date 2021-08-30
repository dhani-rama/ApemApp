package id.research.apemapp.materials.ArrayMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityArrayDetailMaterialsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial.FirstArrayConceptActivity
import id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial.FirstArrayFirstDimensionActivity
import id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial.FirstArraySecondDimensionActivity
import id.research.apemapp.materials.ArrayMaterials.ThirdArrayDimensionMaterial.FirstArrayThirdDimensionActivity

class ArrayDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mArrayDetailMaterialsBinding: ActivityArrayDetailMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mArrayDetailMaterialsBinding = ActivityArrayDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mArrayDetailMaterialsBinding.root)

        mArrayDetailMaterialsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        mArrayDetailMaterialsBinding.cardArrayConcept.setOnClickListener {
            startActivity(Intent(this, FirstArrayConceptActivity::class.java))
            finish()
        }
        mArrayDetailMaterialsBinding.cardFirstArray.setOnClickListener {
            startActivity(Intent(this, FirstArrayFirstDimensionActivity::class.java))
            finish()
        }
        mArrayDetailMaterialsBinding.cardSecondArray.setOnClickListener {
            startActivity(Intent(this, FirstArraySecondDimensionActivity::class.java))
            finish()
        }
        mArrayDetailMaterialsBinding.cardThirdArray.setOnClickListener {
            startActivity(Intent(this, FirstArrayThirdDimensionActivity::class.java))
            finish()
        }

    }
}
package id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArrayFirstDimensionGoalsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class ArrayFirstDimensionGoalsActivity : AppCompatActivity() {

    private lateinit var mArrayFirstGoalsBinding: ActivityArrayFirstDimensionGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArrayFirstGoalsBinding = ActivityArrayFirstDimensionGoalsBinding.inflate(layoutInflater)
        setContentView(mArrayFirstGoalsBinding.root)

        mArrayFirstGoalsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mArrayFirstGoalsBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstArrayFirstDimensionActivity::class.java))
            finish()
        }
    }
}
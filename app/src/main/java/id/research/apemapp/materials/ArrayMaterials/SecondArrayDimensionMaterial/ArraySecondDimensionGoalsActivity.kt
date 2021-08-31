package id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArraySecondDimensionGoalsBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class ArraySecondDimensionGoalsActivity : AppCompatActivity() {

    private lateinit var mArraySecondBinding: ActivityArraySecondDimensionGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArraySecondBinding = ActivityArraySecondDimensionGoalsBinding.inflate(layoutInflater)
        setContentView(mArraySecondBinding.root)

        mArraySecondBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mArraySecondBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstArraySecondDimensionActivity::class.java))
            finish()
        }

    }
}
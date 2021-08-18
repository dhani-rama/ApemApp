package id.research.apemapp.materials.ArrayMaterials.SecondArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstArraySecondDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class FirstArraySecondDimensionActivity : AppCompatActivity() {

    private lateinit var mFirstArray: ActivityFirstArraySecondDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArray = ActivityFirstArraySecondDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArray.root)

        mFirstArray.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mFirstArray.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArraySecondDimensionActivity::class.java))
            finish()
        }

    }
}
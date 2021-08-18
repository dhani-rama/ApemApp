package id.research.apemapp.materials.ArrayMaterials.ThirdArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstArrayThirdDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class FirstArrayThirdDimensionActivity : AppCompatActivity() {

    private lateinit var mFirstArray: ActivityFirstArrayThirdDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArray = ActivityFirstArrayThirdDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArray.root)

        mFirstArray.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mFirstArray.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

    }
}
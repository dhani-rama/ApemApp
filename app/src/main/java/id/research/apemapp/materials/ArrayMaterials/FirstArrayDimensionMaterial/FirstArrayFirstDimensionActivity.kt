package id.research.apemapp.materials.ArrayMaterials.FirstArrayDimensionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstArrayFirstDimensionBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class FirstArrayFirstDimensionActivity : AppCompatActivity() {

    private lateinit var mFirstArrayBinding: ActivityFirstArrayFirstDimensionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstArrayBinding = ActivityFirstArrayFirstDimensionBinding.inflate(layoutInflater)
        setContentView(mFirstArrayBinding.root)

        mFirstArrayBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

        mFirstArrayBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArrayFirstDimensionActivity::class.java))
            finish()
        }
    }
}
package id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityArrayConceptGoalBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class ArrayConceptGoalActivity : AppCompatActivity() {

    private lateinit var mArrayConceptBinding: ActivityArrayConceptGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mArrayConceptBinding = ActivityArrayConceptGoalBinding.inflate(layoutInflater)
        setContentView(mArrayConceptBinding.root)

        mArrayConceptBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }
        mArrayConceptBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstArrayConceptActivity::class.java))
            finish()
        }


    }
}
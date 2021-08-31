package id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFunctionConceptGoalsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FunctionConceptGoalsActivity : AppCompatActivity() {

    private lateinit var mFunctionConceptBinding: ActivityFunctionConceptGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionConceptBinding = ActivityFunctionConceptGoalsBinding.inflate(layoutInflater)
        setContentView(mFunctionConceptBinding.root)

        mFunctionConceptBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
        mFunctionConceptBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstFunctionConceptActivity::class.java))
            finish()
        }
    }
}
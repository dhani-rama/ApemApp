package id.research.apemapp.materials.FunctionMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFunctionDetailMaterialsBinding
import id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial.FirstBuiltInActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial.FirstFunctionConceptActivity

class FunctionDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mFunctionDetailBinding: ActivityFunctionDetailMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFunctionDetailBinding = ActivityFunctionDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mFunctionDetailBinding.root)

        mFunctionDetailBinding.cardFunctionConcept.setOnClickListener {
            startActivity(Intent(this, FirstFunctionConceptActivity::class.java))
            finish()
        }

        mFunctionDetailBinding.cardBuiltInFunction.setOnClickListener {
            startActivity(Intent(this, FirstBuiltInActivity::class.java))
            finish()
        }

    }
}
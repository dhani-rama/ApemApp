package id.research.apemapp.materials.FunctionMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityFunctionDetailMaterialsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial.FirstFunctionConceptActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionFileHeaderMaterial.FirstFileHeaderActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial.FirstParameterActivity
import id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial.FirstVariableActivity

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

        mFunctionDetailBinding.cardVariabelFunction.setOnClickListener {
            startActivity(Intent(this, FirstVariableActivity::class.java))
            finish()
        }

        mFunctionDetailBinding.cardFunctionParameter.setOnClickListener {
            startActivity(Intent(this, FirstParameterActivity::class.java))
            finish()
        }

        mFunctionDetailBinding.cardHeaderFileFunction.setOnClickListener {
            startActivity(Intent(this, FirstFileHeaderActivity::class.java))
            finish()
        }

        mFunctionDetailBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
//
//        mFunctionDetailBinding.cardBuiltInFunction.setOnClickListener {
//            startActivity(Intent(this, FirstBuiltInActivity::class.java))
//            finish()
//        }

    }
}
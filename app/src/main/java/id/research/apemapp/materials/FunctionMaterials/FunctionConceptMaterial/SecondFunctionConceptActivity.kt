package id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondFunctionConceptBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class SecondFunctionConceptActivity : AppCompatActivity() {

    private lateinit var mSecondFunctionBinding: ActivitySecondFunctionConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondFunctionBinding = ActivitySecondFunctionConceptBinding.inflate(layoutInflater)
        setContentView(mSecondFunctionBinding.root)

        mSecondFunctionBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstFunctionConceptActivity::class.java))
            finish()
        }
        mSecondFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
    }
}
package id.research.apemapp.materials.FunctionMaterials.FunctionConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstFunctionConceptBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FirstFunctionConceptActivity : AppCompatActivity() {

    private lateinit var mFirstFunctionBinding: ActivityFirstFunctionConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstFunctionBinding = ActivityFirstFunctionConceptBinding.inflate(layoutInflater)
        setContentView(mFirstFunctionBinding.root)

        mFirstFunctionBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }

        mFirstFunctionBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondFunctionConceptActivity::class.java))
            finish()
        }

    }
}
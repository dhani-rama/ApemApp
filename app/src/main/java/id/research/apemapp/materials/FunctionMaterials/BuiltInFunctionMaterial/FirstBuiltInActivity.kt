package id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstBuiltInBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FirstBuiltInActivity : AppCompatActivity() {

    private lateinit var mFirstBuiltInBinding: ActivityFirstBuiltInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstBuiltInBinding = ActivityFirstBuiltInBinding.inflate(layoutInflater)
        setContentView(mFirstBuiltInBinding.root)

        mFirstBuiltInBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }

        mFirstBuiltInBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondBuiltInActivity::class.java))
            finish()
        }


    }
}
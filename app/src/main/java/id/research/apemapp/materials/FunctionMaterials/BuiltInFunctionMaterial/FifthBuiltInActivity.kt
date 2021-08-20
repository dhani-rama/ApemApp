package id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFifthBuiltInBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FifthBuiltInActivity : AppCompatActivity() {

    private lateinit var mFifthBuiltInBinding: ActivityFifthBuiltInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFifthBuiltInBinding = ActivityFifthBuiltInBinding.inflate(layoutInflater)
        setContentView(mFifthBuiltInBinding.root)

        mFifthBuiltInBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FourthBuiltInActivity::class.java))
            finish()
        }

        mFifthBuiltInBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
    }
}
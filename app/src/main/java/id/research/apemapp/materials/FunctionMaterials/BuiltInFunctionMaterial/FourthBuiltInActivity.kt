package id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFourthBuiltInBinding

class FourthBuiltInActivity : AppCompatActivity() {

    private lateinit var mFourthBuiltInBinding: ActivityFourthBuiltInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFourthBuiltInBinding = ActivityFourthBuiltInBinding.inflate(layoutInflater)
        setContentView(mFourthBuiltInBinding.root)

        mFourthBuiltInBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ThirdBuiltInActivity::class.java))
            finish()
        }
        mFourthBuiltInBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FifthBuiltInActivity::class.java))
            finish()
        }
    }
}
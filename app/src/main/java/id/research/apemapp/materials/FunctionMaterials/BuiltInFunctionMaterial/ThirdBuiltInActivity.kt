package id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityThirdBuiltInBinding

class ThirdBuiltInActivity : AppCompatActivity() {

    private lateinit var mThirdBuiltInBinding: ActivityThirdBuiltInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdBuiltInBinding = ActivityThirdBuiltInBinding.inflate(layoutInflater)
        setContentView(mThirdBuiltInBinding.root)

        mThirdBuiltInBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondBuiltInActivity::class.java))
            finish()
        }
        mThirdBuiltInBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FourthBuiltInActivity::class.java))
            finish()
        }
    }
}
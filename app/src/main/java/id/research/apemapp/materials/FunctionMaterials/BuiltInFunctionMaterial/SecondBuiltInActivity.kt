package id.research.apemapp.materials.FunctionMaterials.BuiltInFunctionMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondBuiltInBinding

class SecondBuiltInActivity : AppCompatActivity() {

    private lateinit var mSecondBuiltInBinding: ActivitySecondBuiltInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondBuiltInBinding = ActivitySecondBuiltInBinding.inflate(layoutInflater)
        setContentView(mSecondBuiltInBinding.root)

        mSecondBuiltInBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstBuiltInActivity::class.java))
            finish()
        }
        mSecondBuiltInBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdBuiltInActivity::class.java))
            finish()
        }
    }
}
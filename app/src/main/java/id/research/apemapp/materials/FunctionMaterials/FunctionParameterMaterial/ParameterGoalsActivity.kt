package id.research.apemapp.materials.FunctionMaterials.FunctionParameterMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityParameterGoalsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class ParameterGoalsActivity : AppCompatActivity() {

    private lateinit var mParameterGoalsBinding: ActivityParameterGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mParameterGoalsBinding = ActivityParameterGoalsBinding.inflate(layoutInflater)
        setContentView(mParameterGoalsBinding.root)

        mParameterGoalsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
        mParameterGoalsBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstParameterActivity::class.java))
            finish()
        }

    }
}
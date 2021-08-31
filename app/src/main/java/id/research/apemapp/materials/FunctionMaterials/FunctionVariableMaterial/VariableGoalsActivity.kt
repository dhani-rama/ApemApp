package id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityVariableGoalsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class VariableGoalsActivity : AppCompatActivity() {

    private lateinit var mVariableGoalsBinding: ActivityVariableGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVariableGoalsBinding = ActivityVariableGoalsBinding.inflate(layoutInflater)
        setContentView(mVariableGoalsBinding.root)

        mVariableGoalsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }

        mVariableGoalsBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstVariableActivity::class.java))
            finish()
        }

    }
}
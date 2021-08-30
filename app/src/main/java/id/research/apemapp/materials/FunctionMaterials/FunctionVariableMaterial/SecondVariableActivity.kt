package id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondVariableBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class SecondVariableActivity : AppCompatActivity() {

    private lateinit var mSecondVariableBinding: ActivitySecondVariableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondVariableBinding = ActivitySecondVariableBinding.inflate(layoutInflater)
        setContentView(mSecondVariableBinding.root)

        mSecondVariableBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstVariableActivity::class.java))
            finish()
        }
        mSecondVariableBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
    }
}
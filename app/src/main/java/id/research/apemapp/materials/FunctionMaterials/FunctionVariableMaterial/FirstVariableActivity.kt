package id.research.apemapp.materials.FunctionMaterials.FunctionVariableMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstVariableBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FirstVariableActivity : AppCompatActivity() {

    private lateinit var mFirstVariableBinding: ActivityFirstVariableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstVariableBinding = ActivityFirstVariableBinding.inflate(layoutInflater)
        setContentView(mFirstVariableBinding.root)

        mFirstVariableBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish();
        }

        mFirstVariableBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondVariableActivity::class.java))
            finish();
        }

    }
}
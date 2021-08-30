package id.research.apemapp.materials.FunctionMaterials.FunctionFileHeaderMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondFileHeaderBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class SecondFileHeaderActivity : AppCompatActivity() {

    private lateinit var mSecondHeaderBinding: ActivitySecondFileHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondHeaderBinding = ActivitySecondFileHeaderBinding.inflate(layoutInflater)
        setContentView(mSecondHeaderBinding.root)

        mSecondHeaderBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstFileHeaderActivity::class.java))
            finish()
        }
        mSecondHeaderBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
        }
    }
}
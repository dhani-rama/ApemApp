package id.research.apemapp.materials.FunctionMaterials.FunctionFileHeaderMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFileHeaderGoalsBinding
import id.research.apemapp.materials.FunctionMaterials.FunctionDetailMaterialsActivity

class FileHeaderGoalsActivity : AppCompatActivity() {

    private lateinit var mFileHeaderBinding: ActivityFileHeaderGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFileHeaderBinding = ActivityFileHeaderGoalsBinding.inflate(layoutInflater)
        setContentView(mFileHeaderBinding.root)

        mFileHeaderBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FunctionDetailMaterialsActivity::class.java))
            finish()
        }
        mFileHeaderBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstFileHeaderActivity::class.java))
            finish()
        }

    }
}
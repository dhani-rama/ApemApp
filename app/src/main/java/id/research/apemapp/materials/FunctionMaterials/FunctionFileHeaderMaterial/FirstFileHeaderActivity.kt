package id.research.apemapp.materials.FunctionMaterials.FunctionFileHeaderMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstFileHeaderBinding

class FirstFileHeaderActivity : AppCompatActivity() {

    private lateinit var mFirstHeaderBinding: ActivityFirstFileHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstHeaderBinding = ActivityFirstFileHeaderBinding.inflate(layoutInflater)
        setContentView(mFirstHeaderBinding.root)

        mFirstHeaderBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FileHeaderGoalsActivity::class.java))
            finish()
        }
        mFirstHeaderBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondFileHeaderActivity::class.java))
            finish()
        }

    }
}
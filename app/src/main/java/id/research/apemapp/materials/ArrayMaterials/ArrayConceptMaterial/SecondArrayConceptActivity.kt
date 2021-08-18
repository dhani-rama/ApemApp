package id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondArrayConceptBinding
import id.research.apemapp.materials.ArrayMaterials.ArrayDetailMaterialsActivity

class SecondArrayConceptActivity : AppCompatActivity() {

    private lateinit var mSecondBinding: ActivitySecondArrayConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondBinding = ActivitySecondArrayConceptBinding.inflate(layoutInflater)
        setContentView(mSecondBinding.root)

        mSecondBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstArrayConceptActivity::class.java))
            finish()
        }

        mSecondBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ArrayDetailMaterialsActivity::class.java))
            finish()
        }

    }
}
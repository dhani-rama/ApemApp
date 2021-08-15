package id.research.apemapp.materials.LoopingMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityLoopingDetailMaterialsBinding
import id.research.apemapp.materials.LoopingMaterials.ForMaterials.FirstForActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterials.FirstLoopingConceptActivity

class LoopingDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mLoopingDetailBinding: ActivityLoopingDetailMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoopingDetailBinding = ActivityLoopingDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mLoopingDetailBinding.root)

        mLoopingDetailBinding.btnBack.setOnClickListener {
            onBackPressed()
        }

        mLoopingDetailBinding.cardLoopingConcept.setOnClickListener {
            startActivity(Intent(this, FirstLoopingConceptActivity::class.java))
            finish()
        }

        mLoopingDetailBinding.cardLoopingFor.setOnClickListener {
            startActivity(Intent(this, FirstForActivity::class.java))
            finish()
        }

    }
}
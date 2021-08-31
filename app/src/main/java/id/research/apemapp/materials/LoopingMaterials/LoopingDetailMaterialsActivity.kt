package id.research.apemapp.materials.LoopingMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.HomeActivity
import id.research.apemapp.databinding.ActivityLoopingDetailMaterialsBinding
import id.research.apemapp.materials.LoopingMaterials.ForMaterial.ForLearningGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial.LoopingConceptGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.NestedForMaterial.NestedForLearningGoalsActivity
import id.research.apemapp.materials.LoopingMaterials.WhileMaterial.WhileLearningGoalsActivity

class LoopingDetailMaterialsActivity : AppCompatActivity() {

    private lateinit var mLoopingDetailBinding: ActivityLoopingDetailMaterialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoopingDetailBinding = ActivityLoopingDetailMaterialsBinding.inflate(layoutInflater)
        setContentView(mLoopingDetailBinding.root)

        mLoopingDetailBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        mLoopingDetailBinding.cardLoopingConcept.setOnClickListener {
            startActivity(Intent(this, LoopingConceptGoalsActivity::class.java))
            finish()
        }

        mLoopingDetailBinding.cardLoopingFor.setOnClickListener {
            startActivity(Intent(this, ForLearningGoalsActivity::class.java))
            finish()
        }

        mLoopingDetailBinding.cardLoopingWhile.setOnClickListener {
            startActivity(Intent(this, WhileLearningGoalsActivity::class.java))
            finish()
        }

        mLoopingDetailBinding.cardLoopingNested.setOnClickListener {
            startActivity(Intent(this, NestedForLearningGoalsActivity::class.java))
            finish()
        }
    }
}
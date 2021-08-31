package id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityLoopingConceptGoalsBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class LoopingConceptGoalsActivity : AppCompatActivity() {

    private lateinit var mLoopingConceptBinding: ActivityLoopingConceptGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoopingConceptBinding = ActivityLoopingConceptGoalsBinding.inflate(layoutInflater)
        setContentView(mLoopingConceptBinding.root)

        mLoopingConceptBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mLoopingConceptBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstLoopingConceptActivity::class.java))
            finish()
        }

    }
}
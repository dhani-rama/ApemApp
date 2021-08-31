package id.research.apemapp.materials.LoopingMaterials.WhileMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityWhileLearningGoalsBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class WhileLearningGoalsActivity : AppCompatActivity() {

    private lateinit var mWhileLearningBinding: ActivityWhileLearningGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mWhileLearningBinding = ActivityWhileLearningGoalsBinding.inflate(layoutInflater)
        setContentView(mWhileLearningBinding.root)

        mWhileLearningBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mWhileLearningBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstWhileActivity::class.java))
            finish()
        }

    }
}
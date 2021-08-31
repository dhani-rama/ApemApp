package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityForLearningGoalsBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class ForLearningGoalsActivity : AppCompatActivity() {

    private lateinit var mForLearningGoalsBinding: ActivityForLearningGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mForLearningGoalsBinding = ActivityForLearningGoalsBinding.inflate(layoutInflater)
        setContentView(mForLearningGoalsBinding.root)

        mForLearningGoalsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mForLearningGoalsBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstForActivity::class.java))
            finish()
        }
    }
}
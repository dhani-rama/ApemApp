package id.research.apemapp.materials.LoopingMaterials.NestedForMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityNestedForLearningGoalsBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class NestedForLearningGoalsActivity : AppCompatActivity() {

    private lateinit var mNestedGoalsBinding: ActivityNestedForLearningGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNestedGoalsBinding = ActivityNestedForLearningGoalsBinding.inflate(layoutInflater)
        setContentView(mNestedGoalsBinding.root)

        mNestedGoalsBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        mNestedGoalsBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FirstNestedForActivity::class.java))
            finish()
        }

    }
}
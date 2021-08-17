package id.research.apemapp.materials.LoopingMaterials.NestedForMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstNestedForBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class FirstNestedForActivity : AppCompatActivity() {

    private lateinit var mFirstNestedBinding: ActivityFirstNestedForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstNestedBinding = ActivityFirstNestedForBinding.inflate(layoutInflater)
        setContentView(mFirstNestedBinding.root)

        mFirstNestedBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }
        mFirstNestedBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondNestedForActivity::class.java))
            finish()
        }

    }
}
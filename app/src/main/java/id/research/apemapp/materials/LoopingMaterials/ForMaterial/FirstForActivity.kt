package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstForBinding
import id.research.apemapp.materials.LoopingMaterials.LoopingDetailMaterialsActivity

class FirstForActivity : AppCompatActivity() {

    private lateinit var firstForBinding: ActivityFirstForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstForBinding = ActivityFirstForBinding.inflate(layoutInflater)
        setContentView(firstForBinding.root)

        firstForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoopingDetailMaterialsActivity::class.java))
            finish()
        }

        firstForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondForActivity::class.java))
            finish()
        }

    }
}
package id.research.apemapp.materials.LoopingMaterials.ForMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondForBinding

class SecondForActivity : AppCompatActivity() {

    private lateinit var mSecondForBinding: ActivitySecondForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondForBinding = ActivitySecondForBinding.inflate(layoutInflater)
        setContentView(mSecondForBinding.root)

        mSecondForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstForActivity::class.java))
            finish()
        }

        mSecondForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdForActivity::class.java))
            finish()
        }

    }
}
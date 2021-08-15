package id.research.apemapp.materials.LoopingMaterials.ForMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondForBinding

class SecondForActivity : AppCompatActivity() {

    private lateinit var secondForBinding: ActivitySecondForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondForBinding = ActivitySecondForBinding.inflate(layoutInflater)
        setContentView(secondForBinding.root)

        secondForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstForActivity::class.java))
            finish()
        }
        secondForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdForActivity::class.java))
        }

    }
}
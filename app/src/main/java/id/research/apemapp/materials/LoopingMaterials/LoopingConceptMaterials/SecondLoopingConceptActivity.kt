package id.research.apemapp.materials.LoopingMaterials.LoopingConceptMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivitySecondLoopingConceptBinding

class SecondLoopingConceptActivity : AppCompatActivity() {

    private lateinit var mSecondLoopingBinding: ActivitySecondLoopingConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSecondLoopingBinding = ActivitySecondLoopingConceptBinding.inflate(layoutInflater)
        setContentView(mSecondLoopingBinding.root)

        mSecondLoopingBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, FirstLoopingConceptActivity::class.java))
            finish()
        }

        mSecondLoopingBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, ThirdLoopingConceptActivity::class.java))
            finish()
        }
    }
}
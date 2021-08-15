package id.research.apemapp.materials.LoopingMaterials.ForMaterials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityThirdForBinding

class ThirdForActivity : AppCompatActivity() {

    private lateinit var mThirdForBinding: ActivityThirdForBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mThirdForBinding = ActivityThirdForBinding.inflate(layoutInflater)
        setContentView(mThirdForBinding.root)

        mThirdForBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, SecondForActivity::class.java))
            finish()
        }

        mThirdForBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, FourthForActivity::class.java))
            finish()
        }


    }
}
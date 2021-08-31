package id.research.apemapp.materials.ArrayMaterials.ArrayConceptMaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityFirstArrayConceptBinding

class FirstArrayConceptActivity : AppCompatActivity() {

    private lateinit var mFirstBinding: ActivityFirstArrayConceptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirstBinding = ActivityFirstArrayConceptBinding.inflate(layoutInflater)
        setContentView(mFirstBinding.root)

        mFirstBinding.btnBack.setOnClickListener {
            startActivity(Intent(this, ArrayConceptGoalActivity::class.java))
            finish()
        }
        mFirstBinding.btnNext.setOnClickListener {
            startActivity(Intent(this, SecondArrayConceptActivity::class.java))
            finish()
        }

    }
}
package id.research.apemapp.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.apemapp.databinding.ActivityDeveloperProfileBinding

class DeveloperProfileActivity : AppCompatActivity() {

    private lateinit var mDeveloperProfileBinding: ActivityDeveloperProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDeveloperProfileBinding = ActivityDeveloperProfileBinding.inflate(layoutInflater)
        setContentView(mDeveloperProfileBinding.root)

        mDeveloperProfileBinding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}
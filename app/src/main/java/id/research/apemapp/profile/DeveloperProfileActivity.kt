package id.research.apemapp.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
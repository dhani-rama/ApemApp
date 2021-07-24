package id.research.apemapp.profile.Alarm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.research.apemapp.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {

    private lateinit var destinationBinding : ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        destinationBinding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(destinationBinding.root)
    }
}
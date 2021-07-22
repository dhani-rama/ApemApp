package id.research.apemapp.home.OnlineCompiler

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import es.dmoral.toasty.Toasty
import id.research.apemapp.R
import id.research.apemapp.databinding.ActivityOnlineCompilerBinding
import id.research.apemapp.retrofit.APIClient.Companion.instance
import id.research.apemapp.utils.MySharedPreferences
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnlineCompilerActivity : AppCompatActivity() {


    private lateinit var onlineCompilerBinding: ActivityOnlineCompilerBinding
    private lateinit var myPreferences: MySharedPreferences
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myPreferences = MySharedPreferences(this)

        onlineCompilerBinding = ActivityOnlineCompilerBinding.inflate(layoutInflater)
        setContentView(onlineCompilerBinding.root)

        setSupportActionBar(onlineCompilerBinding.toolbarEditor)


        supportActionBar?.setTitle("Compiler Online A-PEM")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navController = findNavController(R.id.nav_host_fragment)
//        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }

}
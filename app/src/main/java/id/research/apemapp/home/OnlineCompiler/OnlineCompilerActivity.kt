package id.research.apemapp.home.OnlineCompiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.dmoral.toasty.Toasty
import id.research.apemapp.databinding.ActivityOnlineCompilerBinding
import id.research.apemapp.models.CodeResponseEntity
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
    private lateinit var scriptCode: CodeResponseEntity
    var api = instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myPreferences = MySharedPreferences(this)

        onlineCompilerBinding = ActivityOnlineCompilerBinding.inflate(layoutInflater)
        setContentView(onlineCompilerBinding.root)

        setSupportActionBar(onlineCompilerBinding.toolbarEditor)


        supportActionBar?.setTitle("Compiler Online A-PEM")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onlineCompilerBinding.btnCheck.setOnClickListener {
            compile()
        }

    }

    private fun compile(){
        val execute = api!!.aPI.execute(PostData(onlineCompilerBinding.etInputCode.text.toString()))

        execute!!.enqueue(object : Callback<String?>{
            override fun onResponse(call: Call<String?>, response: Response<String?>) {

                try {
                    if (response.isSuccessful){
                        val jsonObject = JSONObject(response.body())
                        val output = jsonObject.getString("output")
                        val memory = jsonObject.getString("memory")
                        val cpuTime = jsonObject.getString("cpuTime")


                        val intent = Intent(this@OnlineCompilerActivity, ResultCodeActivity::class.java).apply {
                            putExtra(ResultCodeActivity.EXTRA_OUTPUT, output)
                            putExtra(ResultCodeActivity.EXTRA_MEMORY, memory)
                            putExtra(ResultCodeActivity.EXTRA_CPU, cpuTime)
                        }
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toasty.error(this@OnlineCompilerActivity, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: JSONException){
                    e.printStackTrace()
                    Toasty.error(this@OnlineCompilerActivity, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
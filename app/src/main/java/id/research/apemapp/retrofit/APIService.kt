package id.research.apemapp.retrofit

import id.research.apemapp.home.OnlineCompiler.PostData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST("execute")
    fun execute(@Body postData: PostData?): Call<String?>?
}
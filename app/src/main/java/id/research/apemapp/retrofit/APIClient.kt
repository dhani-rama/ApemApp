package id.research.apemapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class APIClient private constructor(builder: OkHttpClient.Builder) {
    private val retrofit: Retrofit
    val aPI: APIService
        get() = retrofit.create(APIService::class.java)

    companion object {
        private const val BASE_URL = "https://api.jdoodle.com/v1/"
        const val API_ID = "a822172d11e300b512cd3138d9542e8c"
        const val API_SECRET = "880e5ea8c48adc837be2cae9d9171260be5b0cba6cbe378624dc0d072d31a928"
        const val LANGUAGE = "cpp"
        const val VERSION_INDEX = "4"
        private var mInstance: APIClient? = null

        @JvmStatic
        @get:Synchronized
        val instance: APIClient?
            get() {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val builder = OkHttpClient.Builder()
                builder.addInterceptor(interceptor)
                if (mInstance == null) {
                    mInstance = APIClient(builder)
                }
                return mInstance
            }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()
    }
}
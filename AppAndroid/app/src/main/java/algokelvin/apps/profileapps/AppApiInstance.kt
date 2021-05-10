package algokelvin.apps.profileapps

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.ArrayList
import java.util.concurrent.TimeUnit

interface AppApiInstance {

    @GET("/demo/all")
    fun getPeople(): Call<ArrayList<People>>

    companion object {
        fun create(link: String): AppApiInstance {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient().newBuilder()

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(25, TimeUnit.SECONDS)
                .readTimeout( 25 , TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

            return retrofit.create(AppApiInstance::class.java)
        }
    }
}
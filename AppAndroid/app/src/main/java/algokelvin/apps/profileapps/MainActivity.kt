package algokelvin.apps.profileapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var appApiInstance: AppApiInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appApiInstance = AppApiInstance.create(BuildConfig.BASE_URL)
        getDataPeople()

        btn_add_1.setOnClickListener {
        }
    }

    private fun getDataPeople() {
        val getPeople = appApiInstance.getPeople()
        getPeople.enqueue(object : Callback<ArrayList<People>> {
            override fun onResponse(call: Call<ArrayList<People>>, response: Response<ArrayList<People>>) {
                rv_item.layoutManager = LinearLayoutManager(this@MainActivity)
                rv_item.adapter = response.body()?.let { DataAdapter(it) }
            }
            override fun onFailure(call: Call<ArrayList<People>>, t: Throwable) {
                Log.e("ResponsePeople", t.message.toString())
            }
        })
    }
}
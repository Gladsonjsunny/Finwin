package com.axisoverseascareers.finwintech

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class FirstActivity : AppCompatActivity() {
   lateinit var dataAdapter: DataAdapter
    private val movieList = ArrayList<Datamodel>()
    val geturl: String ="https://jsonplaceholder.typicode.com/photos"

    fun getdetails() {
        val que = Volley.newRequestQueue(applicationContext)
        val request = StringRequest(
            Request.Method.GET, geturl,
            { response ->
                Log.w("ssssssss", response!!)
                try {
                    val jsonArray = JSONArray(response)
                    for (i in 0 until jsonArray.length()) {
                        val jsn1 = jsonArray.getJSONObject(i)
                        movieList.add(Datamodel(
                                jsn1.getString("albumId"),
                                jsn1.getString("id"),
                                jsn1.getString("title"),
                                jsn1.getString("url"),jsn1.getString("thumbnailUrl"))
                        )
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
               dataAdapter.notifyDataSetChanged()
            }) { }
        que.add(request)
        //request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,3,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

         getdetails()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        dataAdapter = DataAdapter(movieList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = dataAdapter

    }
}
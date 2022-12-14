package com.axisoverseascareers.finwintech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {

    val geturl: String =" https://jsonplaceholder.typicode.com/photos/1"
   lateinit var id: TextView
    lateinit var title: TextView
    lateinit var url: TextView


    fun getdetails() {
        val que = Volley.newRequestQueue(applicationContext)
        val request = StringRequest(
            Request.Method.GET, geturl,
            { response ->
                Log.w("ssssssss", response!!)
                try {
                    val jsn1 = JSONObject(response)



                    Log.w("id", jsn1.getString("id"))

                        id.text = jsn1.getString("id")
                        title.text = jsn1.getString("title")
                        url.text = jsn1.getString("url")


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }) { }
        que.add(request)
        //request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,3,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       id= findViewById(R.id.id)
       title= findViewById(R.id.title1)
       url= findViewById(R.id.url)


        getdetails()




    }
}
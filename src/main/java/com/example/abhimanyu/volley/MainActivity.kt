package com.example.abhimanyu.volley


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val url = "https://reqres.in/api/users/2"
    var rq : RequestQueue? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rq = Volley.newRequestQueue(this)
        button.setOnClickListener {
            getrequest()
        }

    }
    fun getrequest() {
        var jsonObjectRequest = JsonObjectRequest(url , null,
            Response.Listener<JSONObject> { response ->
                Log.e("response" , response.toString())
                var obj = response!!.getJSONObject("data")
                var name = obj.getString("first_name")
                var lastname = obj.getString("last_name")
                var xid  = obj.getString("id")
                fname.text=name
                lname.text = lastname
                id.text = xid
            }, Response.ErrorListener { error -> Log.e("Volley Error",error.toString()) })
        rq!!.add(jsonObjectRequest)
    }


}

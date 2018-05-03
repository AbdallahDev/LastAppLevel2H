package com.example.abdallahsarayrah.lastapplevel2h

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button.setOnClickListener {
            val rq = Volley.newRequestQueue(this)
            val sr = object : StringRequest(Request.Method.POST, "http://10.152.36.151/android/salesh/item_insert.php", Response.Listener { response ->
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
            }) {
                override fun getParams(): MutableMap<String, String> {
                    val map = HashMap<String, String>()
                    map.put("item_name", editText_itemName.text.toString())
                    map.put("item_price", editText_itemPrice.text.toString())
                    map.put("item_category", editText_itemCategory.text.toString())

                    return map
                }
            }
            rq.add(sr)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

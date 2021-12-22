package com.example.retrofitxmlparsing

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitxmlparsing.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter: FeedAdapter
    private lateinit var items: ArrayList<Feed?>

    private val apiFeed = APLClient().getClient()?.create(APIFeed::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        items = arrayListOf()
        recyclerAdapter = FeedAdapter(items)
        binding.feedRV.adapter = recyclerAdapter
        binding.feedRV.layoutManager = LinearLayoutManager(this)

        apiFeed?.feed?.enqueue(object : Callback<ArrayList<Feed?>>{
            override fun onResponse(
                call: Call<ArrayList<Feed?>>,
                response: Response<ArrayList<Feed?>>
            ) {
                items = response!!.body()!!
                recyclerAdapter.showFeed(items)
            }

            override fun onFailure(call: Call<ArrayList<Feed?>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Couldn't get feed", Toast.LENGTH_LONG).show()
            }


        })
    }
}

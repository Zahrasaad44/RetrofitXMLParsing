package com.example.retrofitxmlparsing

import retrofit2.Call
import retrofit2.http.GET

interface APIFeed {

    @get:GET("feed.xml?x=1")
    val feed: Call<Feed>
}
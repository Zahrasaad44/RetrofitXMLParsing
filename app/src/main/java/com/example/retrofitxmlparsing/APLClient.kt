package com.example.retrofitxmlparsing

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class APLClient {
    var retrofit: Retrofit? = null

    fun getClient(): Retrofit?  {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.techmeme.com/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        return  retrofit
    }
}
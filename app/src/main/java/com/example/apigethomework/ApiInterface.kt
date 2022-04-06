package com.example.apigethomework

import com.example.apigethomework.FirstTask.UserData
import com.example.apigethomework.SecondTask.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("marvel")
    fun getData(): Call<List<UserData>>

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    fun getMony(): Call<List<MyDataItem>>
}
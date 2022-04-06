package com.example.apigethomework

import com.example.apigethomework.FirstTask.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("comments?postId=1")
    fun getData(): Call<List<UserData>>
}
package com.example.mvvmsampleapp.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        // @Field value in "" should be same as api object name
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<ResponseBody>

    // this below fuctions used for retrofit calling functions
    companion object{
        operator fun invoke(): MyApi
        {
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}
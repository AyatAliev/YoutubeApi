package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.`object`.Constant
import com.example.model.PlayList
import com.example.network.RetrofitClient
import com.example.remote.YoutubeApi
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {

    private var apiService: YoutubeApi = RetrofitClient.create()

    fun fetchYoutubeApiPlayList(): LiveData<Response<PlayList>> = liveData(Dispatchers.IO) {
        val response = apiService.fetchAllPlayList(Constant.PART,Constant.CHANNEL_ID,Constant.API_KEY)
        emit(response)
    }

}
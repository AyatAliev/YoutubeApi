package com.example.remote

import com.example.`object`.Constant
import com.example.core.network.BaseDataSource
import com.example.core.network.RetrofitClient
import com.example.youtubeapi.BuildConfig

class RemoteDataSource: BaseDataSource() {

    private var apiService: YoutubeApi = RetrofitClient.create()

    suspend fun fetchAllPlaylist() = getResult {
        apiService.fetchAllPlayList(Constant.PART,Constant.CHANNEL_ID,Constant.API_KEY)
    }

}
package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.`object`.Constant
import com.example.model.PlayList
import com.example.core.network.RetrofitClient
import com.example.core.network.result.Resource
import com.example.remote.RemoteDataSource
import com.example.remote.YoutubeApi
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository(private val dataSource: RemoteDataSource) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchAllPlaylist()
        emit(response)
    }

}
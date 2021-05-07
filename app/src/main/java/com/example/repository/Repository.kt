package com.example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.model.PlayList
import com.example.core.network.result.Resource
import com.example.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchAllPlaylist()
        emit(response)
    }

    fun getResult(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.result()
        emit(response)

    }

}
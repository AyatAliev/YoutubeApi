package com.example.remote

import com.example.`object`.Constant
import com.example.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: YoutubeApi): BaseDataSource() {

    suspend fun fetchAllPlaylist() = getResult {
        apiService.fetchAllPlayList(Constant.PART,Constant.CHANNEL_ID,Constant.API_KEY)
    }

    suspend fun result() = getResult {
        apiService.fetcAllPlayList(Constant.PART,Constant.CHANNEL_ID,Constant.API_KEY,60)
    }

}
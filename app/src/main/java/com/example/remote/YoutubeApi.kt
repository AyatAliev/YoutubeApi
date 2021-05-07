package com.example.remote

import com.example.model.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
    ): Response<PlayList>

    @GET("playlist")
    suspend fun fetcAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        result: Int = 60
    ): Response<PlayList>

}
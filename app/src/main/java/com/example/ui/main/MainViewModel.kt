package com.example.ui.main

import androidx.lifecycle.LiveData
import com.example.YouTubeApp
import com.example.core.ui.BaseViewModel
import com.example.model.PlayList
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<Response<PlayList>> {
        return YouTubeApp.repository.fetchYoutubeApiPlayList()
    }
}
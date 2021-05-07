package com.example.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.BaseViewModel
import com.example.model.PlayList
import com.example.repository.Repository
import retrofit2.Response

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun fetchPlayList(): LiveData<Resource<PlayList>> {
        return repository.fetchYoutubeApiPlayList()
    }

    fun fetchList(): LiveData<Resource<PlayList>> {
        return repository.getResult()
    }

}
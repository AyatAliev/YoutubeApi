package com.example.ui.main

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.network.result.Status
import com.example.core.ui.BaseActivity
import com.example.extensions.showMessage
import com.example.extensions.visible
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), OnItem {

    private var viewModel: MainViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun setupLiveData() {
        initRecyclerView()
    }

    private fun initRecyclerView() {

        viewModel?.loading?.observe(this,{
            loading.visible = it
        })

        viewModel?.fetchPlayList()?.observe(this,{ resource ->


            when(resource.status) {

                Status.LOADING -> {
                    viewModel?.loading?.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel?.loading?.postValue(false)
                }
                Status.ERROR -> {
                    viewModel?.loading?.postValue(false)
                    showMessage(resource.message)
                }
            }
        })
    }

    override fun showDisconnectState() {

    }

    override fun onPlayListItemClick(id: String) {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show()
    }


}
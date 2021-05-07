package com.example.ui.main

import android.widget.Toast
import com.example.core.network.result.Status
import com.example.core.ui.BaseActivity
import com.example.extensions.showMessage
import com.example.extensions.visible
import com.example.local.AppPrefs
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main), OnItem {

    private val viewModel: MainViewModel by viewModel()

    private val prefs: AppPrefs by inject()

    override fun setupUI() {

    }

    override fun setupLiveData() {
        initRecyclerView()
    }

    private fun initRecyclerView() {

        viewModel.loading.observe(this,{
            loading.visible = it
        })

        viewModel.fetchList().observe(this,{

        })

        viewModel.fetchPlayList().observe(this,{ resource ->

            when(resource.status) {

                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    showMessage(resource.data.toString())
                }
                Status.ERROR -> {
                    viewModel.loading.postValue(false)
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
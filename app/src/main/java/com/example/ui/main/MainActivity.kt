package com.example.ui.main

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.BaseActivity
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
        viewModel?.fetchPlayList()?.observe(this, {
            val playListAdapter = it.body()?.let { it1 -> Adapter(this, it1) }
            recycler_view.layoutManager = LinearLayoutManager(baseContext)
            recycler_view.adapter = playListAdapter

        })
    }

    override fun showDisconnectState() {

    }

    override fun onPlayListItemClick(id: String) {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show()
    }


}
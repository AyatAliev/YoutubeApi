package com.example.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.extensions.inflate
import com.example.extensions.loadImage
import com.example.model.Items
import com.example.model.PlayList
import com.example.youtubeapi.R
import kotlinx.android.synthetic.main.item_playlist.view.*

class Adapter(
    private val listener: OnItem,
    private val playList: PlayList
): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(parent.inflate(R.layout.item_playlist
           ,false),listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playList.items[position])

    }

    override fun getItemCount() = playList.items.size

}

class ViewHolder(itemView: View, var listener: OnItem)
    : RecyclerView.ViewHolder(itemView) {

    fun onBind(playList: Items) {

        itemView.textTitle.text = playList.snippet.title

        itemView.imageView.loadImage(itemView.context,
            playList.snippet.thumbnails.default.url)

        itemView.setOnClickListener {
            listener.onPlayListItemClick(playList.id)
        }

    }
}

interface OnItem {
    fun onPlayListItemClick(id: String)
}

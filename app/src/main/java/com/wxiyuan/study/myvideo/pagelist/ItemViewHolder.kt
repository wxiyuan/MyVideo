package com.wxiyuan.study.myvideo.pagelist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.wxiyuan.study.myvideo.PlayerActivity
import kotlinx.android.synthetic.main.video_list_item.view.*

class ItemViewHolder(private val rootView: View) :
    RecyclerView.ViewHolder(rootView) {

    @SuppressLint("SetTextI18n")
    fun bind(url: String) {
        rootView.list_item_btn.text = "Video ${absoluteAdapterPosition + 1}"
        rootView.list_item_btn.setOnClickListener { startPlayerActivity(url) }
    }

    private fun startPlayerActivity(url: String) {
        val args = Bundle().apply {
            putString("url", url)
        }
        Intent(itemView.context, PlayerActivity::class.java).run {
            putExtras(args)
            itemView.context.startActivity(this)
        }
    }
}
package com.wxiyuan.study.myvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LOW_PROFILE
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        setContentView(R.layout.activity_player)
        init()
    }

    override fun onDestroy() {
        PlayerManager.releasePlayer()
        super.onDestroy()
    }

    private fun init() {
        PlayerManager.initPlayer(this@PlayerActivity)

        PlayerManager.getPlayer()?.run {
            player_view.player = this
            intent.extras?.getString("url")?.let {
                PlayerManager.playWithUrl(this@PlayerActivity, it)
            }
        }
    }
}
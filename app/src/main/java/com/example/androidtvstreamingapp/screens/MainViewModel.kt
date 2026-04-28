package com.example.androidtvstreamingapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.androidtvstreamingapp.data.VideoItem
import com.example.androidtvstreamingapp.data.sampleVideos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _videos = MutableStateFlow(sampleVideos)
    val videos: StateFlow<List<VideoItem>> = _videos

    private var activePreviewUrl: String? = null

    val previewPlayer: ExoPlayer by lazy {
        ExoPlayer.Builder(application).build().apply {
            volume = 0f
            repeatMode = ExoPlayer.REPEAT_MODE_ONE
        }
    }

    fun playPreview(url: String) {
        if (activePreviewUrl == url) return
        activePreviewUrl = url

        previewPlayer.stop()
        previewPlayer.clearMediaItems()
        
        val mediaItem = MediaItem.fromUri(url)
        // resetPosition = true ensures we start from the beginning and clear previous state
        previewPlayer.setMediaItem(mediaItem, true)
        previewPlayer.prepare()
        previewPlayer.playWhenReady = true
    }

    fun stopPreview(url: String? = null) {
        // Only stop if the URL being stopped is the one currently playing, 
        // or if no URL is provided (emergency stop).
        if (url == null || activePreviewUrl == url) {
            activePreviewUrl = null
            previewPlayer.stop()
            previewPlayer.clearMediaItems()
        }
    }

    override fun onCleared() {
        super.onCleared()
        previewPlayer.release()
    }
}
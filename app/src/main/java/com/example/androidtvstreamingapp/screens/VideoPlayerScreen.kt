package com.example.androidtvstreamingapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.androidtvstreamingapp.ui.theme.AndroidTvStreamingAppTheme
import java.net.URLDecoder

@Composable
fun VideoPlayerScreen(videoUrl: String, onBack: () -> Unit) {
    val context = LocalContext.current
    val isInPreview = androidx.compose.ui.platform.LocalInspectionMode.current
    val decodedUrl = remember(videoUrl) { 
        try {
            URLDecoder.decode(videoUrl, "UTF-8")
        } catch (e: Exception) {
            videoUrl
        }
    }
    val exoPlayer = remember {
        if (isInPreview) null
        else ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(decodedUrl))
            prepare()
            playWhenReady = true
        }
    }

    BackHandler { onBack() }
    DisposableEffect(Unit) { onDispose { exoPlayer?.release() } }

    AndroidView(
        factory = {
            if (isInPreview) {
                android.widget.FrameLayout(it).apply {
                    setBackgroundColor(android.graphics.Color.BLACK)
                    addView(android.widget.TextView(it).apply {
                        text = "Video Player Preview"
                        setTextColor(android.graphics.Color.WHITE)
                        gravity = android.view.Gravity.CENTER
                    })
                }
            } else {
                PlayerView(it).apply { player = exoPlayer; useController = true }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(device = "id:tv_1080p")
@Composable
fun VideoPlayerScreenPreview() {
    AndroidTvStreamingAppTheme {
        VideoPlayerScreen(videoUrl = "https://example.com/video.mp4", onBack = {})
    }
}

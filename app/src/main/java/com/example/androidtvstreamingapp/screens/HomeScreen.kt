package com.example.androidtvstreamingapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.PlayerView
import androidx.tv.material3.*
import coil.compose.AsyncImage
import com.example.androidtvstreamingapp.MainViewModel
import com.example.androidtvstreamingapp.data.VideoItem
import com.example.androidtvstreamingapp.ui.theme.AndroidTvStreamingAppTheme
import kotlinx.coroutines.delay

@UnstableApi
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: MainViewModel, onVideoClick: (VideoItem) -> Unit) {
    val videos by viewModel.videos.collectAsState()
    val videosByCategory = remember(videos) { videos.groupBy { it.category } }
    val configuration = LocalConfiguration.current
    val isTv = (configuration.uiMode and android.content.res.Configuration.UI_MODE_TYPE_MASK) ==
            android.content.res.Configuration.UI_MODE_TYPE_TELEVISION
    val sidePadding = if (isTv) 58.dp else 20.dp

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text("Video Browser",
                style = if (isTv) MaterialTheme.typography.displayMedium else MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = sidePadding, vertical = 32.dp))
        }

        items(videosByCategory.keys.toList()) { category ->
            Text(category, style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = sidePadding, bottom = 8.dp))

            LazyRow(contentPadding = PaddingValues(horizontal = sidePadding, vertical = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                items(videosByCategory[category] ?: emptyList()) { video ->
                    VideoCard(video, isTv, viewModel) { onVideoClick(video) }
                }
            }
        }
    }
}

@UnstableApi
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun VideoCard(video: VideoItem, isTv: Boolean, viewModel: MainViewModel, onClick: () -> Unit) {
    var isFocused by remember { mutableStateOf(false) }
    val isInPreview = androidx.compose.ui.platform.LocalInspectionMode.current

    LaunchedEffect(isFocused) {
        if (!isInPreview && isFocused) {
            delay(1000)
            viewModel.playPreview(video.videoUrl)
        } else if (!isFocused) {
            viewModel.stopPreview(video.videoUrl)
        }
    }

    DisposableEffect(video.videoUrl) {
        onDispose {
            if (!isInPreview) {
                viewModel.stopPreview(video.videoUrl)
            }
        }
    }

    val cardModifier = if (isTv) {
        Modifier
            .width(280.dp)
            .aspectRatio(16 / 9f)
            .onFocusChanged { isFocused = it.isFocused }
    } else {
        Modifier
            .width(180.dp)
            .aspectRatio(16 / 9f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
    }

    Card(
        onClick = onClick,
        modifier = cardModifier
    ) {
        Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray)) {
            // 1. Background Content (Video or Image)
            if (!isInPreview && isFocused) {
                AndroidView(
                    factory = { context ->
                        PlayerView(context).apply {
                            player = viewModel.previewPlayer
                            useController = false
                            resizeMode = androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                AsyncImage(
                    model = video.thumbnailUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // 2. Gradient Overlay (Only visible when not playing video to keep title readable)
            if (!isFocused) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                                // Adjust startY to change where the shadow begins
                                startY = 100f
                            )
                        )
                )
            }

            // 3. Title Text
            Text(
                text = video.title,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}

@UnstableApi
@androidx.compose.ui.tooling.preview.Preview(device = "id:tv_1080p")
@Composable
fun HomeScreenPreview() {
    val context = androidx.compose.ui.platform.LocalContext.current
    val application = remember(context) {
        try {
            context.applicationContext as android.app.Application
        } catch (e: Exception) {
            object : android.app.Application() {}
        }
    }
    AndroidTvStreamingAppTheme {
        HomeScreen(viewModel = MainViewModel(application), onVideoClick = {})
    }
}
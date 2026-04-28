package com.example.androidtvstreamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.tv.material3.*
import androidx.media3.common.util.UnstableApi
import com.example.androidtvstreamingapp.screens.*
import java.net.URLEncoder

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    @UnstableApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainVm: MainViewModel = viewModel()
            val navController = rememberNavController()
            Surface {
                NavHost(navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(mainVm) { video ->
                            val encodedUrl = URLEncoder.encode(video.videoUrl, "UTF-8")
                            navController.navigate("player/$encodedUrl")
                        }
                    }
                    composable(
                        "player/{videoUrl}",
                        arguments = listOf(navArgument("videoUrl") { type = NavType.StringType })
                    ) { backStack ->
                        val url = backStack.arguments?.getString("videoUrl") ?: ""
                        VideoPlayerScreen(url) {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}

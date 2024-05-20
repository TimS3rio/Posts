package com.timserio.posts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.timserio.posts.repository.PostsRepository
import com.timserio.posts.ui.theme.PostsTheme
import com.timserio.posts.viewmodel.PostsViewModel
import com.timserio.posts.viewmodel.PostsViewModelFactory

class MainActivity : ComponentActivity() {
    private val viewModel: PostsViewModel by viewModels {
        PostsViewModelFactory(PostsRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostsTheme {
                val navController = rememberNavController()
                PostsNavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}

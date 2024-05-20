package com.timserio.posts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.timserio.posts.model.Post
import com.timserio.posts.view.PostDetailScreen
import com.timserio.posts.view.PostsListScreen
import com.timserio.posts.viewmodel.PostsViewModel

private const val LIST_ROUTE = "list"
private const val DETAIL_ROUTE = "detail/{post}"
private const val POST_ARGUMENT = "post"

@Composable
fun PostsNavGraph(navController: NavHostController, viewModel: PostsViewModel) {
    NavHost(navController = navController, startDestination = LIST_ROUTE) {
        composable(LIST_ROUTE) {
            PostsListScreen(navController = navController, viewModel = viewModel)
        }
        composable(DETAIL_ROUTE) { backStackEntry ->
            val postJson = backStackEntry.arguments?.getString(POST_ARGUMENT)
            val post = Gson().fromJson(postJson, Post::class.java)
            PostDetailScreen(post)
        }
    }
}

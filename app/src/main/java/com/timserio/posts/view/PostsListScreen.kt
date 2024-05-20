package com.timserio.posts.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.timserio.posts.R
import com.timserio.posts.model.Post
import com.timserio.posts.model.PostListState
import com.timserio.posts.viewmodel.PostsViewModel

@Composable
fun PostsListScreen(navController: NavController, viewModel: PostsViewModel) {
    when (val state = viewModel.postListState.collectAsState().value) {
        is PostListState.Loading -> PostsText(text = stringResource(id = R.string.loading))
        is PostListState.Success -> {
            LazyColumn {
                items(state.posts) { post ->
                    PostListItem(post, onItemClick = {
                        val postJson = Gson().toJson(post)
                        navController.navigate("detail/$postJson") })
                }
            }
        }
        is PostListState.Error -> PostsText(text = stringResource(id = R.string.error, state.error))
    }
}

@Composable
fun PostListItem(post: Post, onItemClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(16.dp)
    ) {
        Card {
            Text(
                text = post.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Text(text = post.body, modifier = Modifier.padding(10.dp))
        }
    }
}

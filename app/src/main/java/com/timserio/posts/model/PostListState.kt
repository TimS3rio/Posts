package com.timserio.posts.model

sealed class PostListState {
    object Loading : PostListState()
    data class Success(val posts: List<Post>) : PostListState()
    data class Error(val error: String) : PostListState()
}

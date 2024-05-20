package com.timserio.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timserio.posts.model.PostListState
import com.timserio.posts.repository.PostsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostsViewModel(private val repository: PostsRepository) : ViewModel() {
    private val _postListState = MutableStateFlow<PostListState>(PostListState.Loading)
    val postListState: StateFlow<PostListState> = _postListState

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _postListState.value = PostListState.Success(posts)
            } catch (e: Exception) {
                _postListState.value = PostListState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}

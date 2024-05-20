package com.timserio.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timserio.posts.repository.PostsRepository

class PostsViewModelFactory(private val repository: PostsRepository) : ViewModelProvider.Factory {
    companion object {
        private const val UNKNOWN_VM_CLASS = "Unknown ViewModel class"
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostsViewModel::class.java)) {
            return PostsViewModel(repository) as T
        }
        throw IllegalArgumentException(UNKNOWN_VM_CLASS)
    }
}

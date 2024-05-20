package com.timserio.posts.repository

import com.timserio.posts.model.Post
import com.timserio.posts.network.RetrofitInstance

class PostsRepository {
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}

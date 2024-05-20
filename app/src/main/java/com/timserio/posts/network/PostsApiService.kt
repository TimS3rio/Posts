package com.timserio.posts.network

import com.timserio.posts.model.Post
import retrofit2.http.GET

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}

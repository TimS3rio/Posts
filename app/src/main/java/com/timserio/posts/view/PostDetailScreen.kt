package com.timserio.posts.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timserio.posts.model.Post

@Composable
fun PostDetailScreen(post: Post) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = post.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(text = post.body, modifier = Modifier.padding(10.dp))
    }
}

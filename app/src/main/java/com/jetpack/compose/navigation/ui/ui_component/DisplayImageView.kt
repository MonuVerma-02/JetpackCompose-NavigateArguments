package com.jetpack.compose.navigation.ui.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun DisplayImageView(url: String?, size: Dp = 80.dp) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            transformations(CircleCropTransformation())
        },
    )
    Image(
        modifier = Modifier
            .size(size)
            .padding(all = 10.dp),
        painter = painter,
        contentDescription = "ImageView"
    )
}
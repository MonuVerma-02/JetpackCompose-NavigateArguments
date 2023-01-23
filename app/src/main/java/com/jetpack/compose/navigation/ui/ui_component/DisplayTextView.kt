package com.jetpack.compose.navigation.ui.ui_component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun DisplayTextView(message: String, style: TextStyle) {
    Text(
        text = message,
        fontSize = style.fontSize,
        color = style.color,
        style = MaterialTheme.typography.h4,
    )
}
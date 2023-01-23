package com.jetpack.compose.navigation.ui.ui_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DisplayAppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable { iconClickAction.invoke() }
            )
        }
    )
}
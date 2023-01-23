package com.jetpack.compose.navigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.navigation.common.userProfileList
import com.jetpack.compose.navigation.ui.ui_component.DisplayAppBar
import com.jetpack.compose.navigation.ui.ui_component.DisplayImageView
import com.jetpack.compose.navigation.ui.ui_component.DisplayTextView

@Composable
fun UserProfileDetailsScreen(userId: Int, navController: NavHostController) {
    Scaffold(topBar = {
        DisplayAppBar(
            title = "User Details",
            icon = Icons.Default.ArrowBack
        ) {
            navController.navigateUp()
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
            UserProfileDetailsContent(userId)
        }
    }
}

@Composable
fun UserProfileDetailsContent(userId: Int) {
    val userProfile = userProfileList.first { userProfile -> userId == userProfile.id }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayImageView(url = userProfile.pictureUrl, size = 250.dp)
        DisplayTextView(
            message = userProfile.name,
            style = TextStyle(color = Color.White, fontSize = 20.sp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {
    val navController = rememberNavController()
    UserProfileDetailsScreen(1, navController)
}
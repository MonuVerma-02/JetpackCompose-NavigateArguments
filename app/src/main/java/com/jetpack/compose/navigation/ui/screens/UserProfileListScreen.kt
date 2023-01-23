package com.jetpack.compose.navigation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.navigation.common.UserProfile
import com.jetpack.compose.navigation.common.userProfileList
import com.jetpack.compose.navigation.ui.navigation.Screen
import com.jetpack.compose.navigation.ui.ui_component.DisplayAppBar
import com.jetpack.compose.navigation.ui.ui_component.DisplayImageView
import com.jetpack.compose.navigation.ui.ui_component.DisplayTextView

@Composable
fun UserProfileListScreen(userProfiles: ArrayList<UserProfile>, navController: NavHostController) {
    Scaffold(topBar = {
        DisplayAppBar(title = "User List", icon = Icons.Default.Home) {
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    UserProfileListContent(userProfile = userProfile) {
                        // this will navigate to details screen
                        navController.navigate("${Screen.UserDetails.route}/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun UserProfileListContent(userProfile: UserProfile, clickAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { clickAction.invoke() }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        DisplayImageView(url = userProfile.pictureUrl)
        DisplayTextView(
            message = userProfile.name,
            style = TextStyle(color = Color.White, fontSize = 18.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileListPreview() {
    val navController = rememberNavController()
    UserProfileListScreen(userProfiles = userProfileList, navController)
}
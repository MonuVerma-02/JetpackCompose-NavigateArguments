package com.jetpack.compose.navigation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.navigation.common.UserProfile
import com.jetpack.compose.navigation.common.userProfileList
import com.jetpack.compose.navigation.ui.screens.UserProfileDetailsScreen
import com.jetpack.compose.navigation.ui.screens.UserProfileListScreen

@Composable
fun Navigation(userProfiles: ArrayList<UserProfile> = userProfileList) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.UserList.route) {
        composable(route = Screen.UserList.route) {
            UserProfileListScreen(userProfiles, navController)
        }

        //By default, all arguments are parsed as strings or you can specify another type by using the arguments parameter to set a type.
        composable(
            route = "${Screen.UserDetails.route}/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            UserProfileDetailsScreen(navBackStackEntry.arguments!!.getInt("userId"), navController)
        }
    }
}
package com.jetpack.compose.navigation.ui.navigation

sealed class Screen(val route: String) {
    object UserList : Screen(route = "user_list")
    object UserDetails : Screen(route = "user_details")
}
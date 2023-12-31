package com.uv72dev.littlelemon

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationComposable(
    startDestination: Destinations,
    sharedPreferences: SharedPreferences,
    menuItems: List<MenuItemRoom>
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination.route){
        composable(Home.route){
            Home(navController, sharedPreferences, menuItems)
        }
        composable(Onboarding.route){
            Onboarding(navController, sharedPreferences)
        }
        composable(Profile.route){
            Profile(navController, sharedPreferences)
        }
    }
}
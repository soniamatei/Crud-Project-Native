package com.example.catminder

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph (
    navController: NavHostController
) {
    val listViewModel = viewModel<PasswordsListViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screen.ListView.route
    ) {
        composable(
            route = Screen.ListView.route
        ){
            RecyclerView(navController, listViewModel)
        }
        composable(
            route = Screen.AppUpdate.route + "/{set}/{id}" ,
            arguments = listOf(
                navArgument("set"){ type = NavType.IntType },
                navArgument("id"){ type = NavType.IntType })
        ) {entry ->
            val set = entry.arguments?.getInt("set") ?: 0
            val id = entry.arguments?.getInt("id")
            AddUpdateView(setting = set, id = id, navCtrl = navController, listViewModel)
        }
        composable(
            route = Screen.AppUpdate.route + "/{set}" ,
            arguments = listOf(
                navArgument("set"){ type = NavType.IntType })
        ){entry ->
            val set = entry.arguments?.getInt("set") ?: 0
            AddUpdateView(setting = set, navCtrl = navController, list = listViewModel)
        }
    }
}
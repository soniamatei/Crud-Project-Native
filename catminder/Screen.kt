package com.example.catminder

sealed class Screen(val route: String) {
    object ListView: Screen("listview_screen")
    object AppUpdate: Screen("app_update_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
package com.diphrogram.sciadvapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.diphrogram.sciadvapp.data.ENTRY_KEY
import com.diphrogram.sciadvapp.theme.SciAdvTheme
import com.diphrogram.sciadvapp.ui.screens.entry.EntryScreen
import com.diphrogram.sciadvapp.ui.screens.main.EntriesScreen
import com.diphrogram.sciadvapp.utility.Screen

@Composable
fun AppStartScreen(
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SciAdvTheme.colors.background)
    ) {
        NavigationGraph(navHostController = navController)
    }
}

@Composable
fun NavigationGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.Entries.route) {
        composable(Screen.Entries.route){
            EntriesScreen(navHostController = navHostController)
        }
        composable(Screen.Entry.route) {
            EntryScreen(
                navController = navHostController,
                entryName = navHostController.previousBackStackEntry!!.savedStateHandle.get<String>(ENTRY_KEY)!!,
                 entryCoverColor = "#7C7C7E",
                topBarColor = "#7C7C7E"
            )
        }
    }
}
package com.pradeep.novacrypto.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pradeep.novacrypto.presentation.explore.ExploreScreen
import com.pradeep.novacrypto.presentation.market.MarketsScreen
import com.pradeep.novacrypto.presentation.navigation.Screen
import com.pradeep.novacrypto.presentation.navigation.bottomNavItems
import com.pradeep.novacrypto.presentation.portfolio.PortfolioScreen
import com.pradeep.novacrypto.presentation.watchlist.WatchlistScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val novaDestination = navBackStackEntry?.destination

    Scaffold(
        topBar = {},
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    val isSelected = novaDestination?.hierarchy?.any() { it.route == item.route } == true
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.name) },
                        label = { Text(text = item.name) },
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Market.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Market.route) {
                MarketsScreen()
            }
            composable(Screen.Explore.route) {
                ExploreScreen()
            }
            composable(Screen.Portfolio.route) {
                PortfolioScreen()
            }
            composable(Screen.Watchlist.route) {
                WatchlistScreen()
            }
        }
    }
}
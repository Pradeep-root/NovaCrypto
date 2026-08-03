package com.pradeep.novacrypto.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val novaDestination = navBackStackEntry?.destination

    val title = when (novaDestination?.route) {
        Screen.Market.route -> "Markets"
        Screen.Explore.route -> "Explore"
        Screen.Portfolio.route -> "Portfolio"
        Screen.Watchlist.route -> "Watchlist"
        else -> "Nova Crypto"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title, style = MaterialTheme.typography.titleLarge)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                scrollBehavior = null
            )
        },
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

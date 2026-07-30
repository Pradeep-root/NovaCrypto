package com.pradeep.novacrypto.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Market : Screen(route = "markets", title = "Markets", icon = Icons.Default.AutoGraph)
    data object Explore : Screen(route = "explore", title = "Explore", icon = Icons.Default.Search)
    data object Portfolio : Screen(route = "portfolio", title = "Portfolio", icon = Icons.Default.AccountBalanceWallet)
    data object Watchlist : Screen(route = "watchlist", title = "Watchlist", icon = Icons.Default.StarBorder)
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Market.title, Screen.Market.route, Screen.Market.icon),
    BottomNavItem(Screen.Explore.title, Screen.Explore.route, Screen.Explore.icon),
    BottomNavItem(Screen.Portfolio.title, Screen.Portfolio.route, Screen.Portfolio.icon),
    BottomNavItem(Screen.Watchlist.title, Screen.Watchlist.route, Screen.Watchlist.icon)
)
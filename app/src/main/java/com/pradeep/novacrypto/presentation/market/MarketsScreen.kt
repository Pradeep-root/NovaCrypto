package com.pradeep.novacrypto.presentation.market

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MarketsScreen(viewModel: MarketScreenViewModel = hiltViewModel()) {
    Text(text = "MarketsScreen")
}
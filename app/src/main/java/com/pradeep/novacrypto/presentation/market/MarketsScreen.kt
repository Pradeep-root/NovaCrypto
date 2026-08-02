package com.pradeep.novacrypto.presentation.market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pradeep.novacrypto.domain.model.GlobalMarket

@Composable
fun MarketsScreen(
    viewModel: MarketScreenViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        MarketUiState.Loading -> {}

        is MarketUiState.Success -> {
            MarketContent(globalMarket = state.market)
        }

        is MarketUiState.Error -> ErrorContent(
            message = state.message, onRetry = { }
        )

    }

}

@Composable
private fun ErrorContent(message: String, onRetry: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = message, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onRetry) { Text("Retry") }
        }
    }
}

@Composable
private fun MarketContent(globalMarket: GlobalMarket) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            GlobalMarketCard(globalMarket)
        }
    }
}

@Composable
private fun GlobalMarketCard(globalMarket: GlobalMarket) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

            Text("GLOBAL MARKET", style = MaterialTheme.typography.labelMedium)
        }
    }
}

@Preview
@Composable
fun GlobalMarketCardPreview() {
    val dummyGlobalMarket = GlobalMarket(
        marketCap = 2_236_582_590_502.68,
        volume24hrs = 35_378_403_141.94,
        volume24hrsPercent = -49.26,
        btcPercentage = 56.20,
        ethPercentage = 10.03,
        othersPercentage = 33.77
    )
    GlobalMarketCard(globalMarket = dummyGlobalMarket)
}


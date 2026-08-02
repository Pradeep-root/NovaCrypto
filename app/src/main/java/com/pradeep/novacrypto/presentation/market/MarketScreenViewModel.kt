package com.pradeep.novacrypto.presentation.market

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pradeep.novacrypto.core.common.ApiResult
import com.pradeep.novacrypto.core.common.toUserMessage
import com.pradeep.novacrypto.domain.model.GlobalMarket
import com.pradeep.novacrypto.domain.usecase.GetGlobalMarketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketScreenViewModel @Inject constructor(
    private val getGlobalMarketUseCase: GetGlobalMarketUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MarketUiState>(MarketUiState.Loading)
    val uiState: StateFlow<MarketUiState> = _uiState.asStateFlow()

    init {
        getGlobalMarketData()
    }

    private fun getGlobalMarketData() {
        viewModelScope.launch {
            when (val result = getGlobalMarketUseCase()) {
                is ApiResult.Success -> {
                    _uiState.value = MarketUiState.Success(result.data)
                }
                is ApiResult.Error -> {
                    _uiState.value = MarketUiState.Error(result.exception.toUserMessage())
                }
            }
        }
    }

}

sealed class MarketUiState {

    data object Loading : MarketUiState()
    data class Success(val market: GlobalMarket) : MarketUiState()
    data class Error(val message: String) : MarketUiState()
}


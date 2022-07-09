package com.example.crypto.presentation.coin_detail

import com.example.crypto.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail ?= CoinDetail(),
    val message: String = ""
)

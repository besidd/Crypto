package com.example.crypto.data.remote.dto


import com.example.crypto.domain.models.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_active")
    val isActive: Boolean? = false,
    @SerializedName("is_new")
    val isNew: Boolean? = false,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("rank")
    val rank: Int? = 0,
    @SerializedName("symbol")
    val symbol: String? = "",
    @SerializedName("type")
    val type: String? = ""
)

fun CoinDto.toCoin() = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol
)
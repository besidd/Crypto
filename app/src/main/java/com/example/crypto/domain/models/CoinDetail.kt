package com.example.crypto.domain.models

import com.example.crypto.data.remote.dto.CoinDetailDto

data class CoinDetail(
    val coinId: String? = "",
    val name: String? = "",
    val description: String? = "",
    val symbol: String? = "",
    val rank: Int? = 0,
    val isActive: Boolean? = false,
    val tags: List<String?>? = listOf(),
    val team: List<CoinDetailDto.TeamMember> = listOf()
)
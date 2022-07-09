package com.example.crypto.data.repository

import com.example.crypto.data.remote.CoinPaprikaAPI
import com.example.crypto.data.remote.dto.CoinDto
import com.example.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaAPI) :
    CoinRepository {

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)

}
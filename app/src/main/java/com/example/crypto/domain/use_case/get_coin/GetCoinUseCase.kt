package com.example.crypto.domain.use_case.get_coin

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.toCoinDetails
import com.example.crypto.domain.models.CoinDetail
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Something went wrong."))
                }
                is SocketTimeoutException, is SocketException -> {
                    emit(Resource.Error<CoinDetail>("Couldn't reach server at the moment"))
                }
            }
        }
    }
}
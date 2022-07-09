package com.example.crypto.domain.use_case.get_coins

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.toCoin
import com.example.crypto.domain.models.Coin
import com.example.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.net.SocketException
import java.net.SocketTimeoutException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coin))
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    emit(Resource.Error(e.localizedMessage ?: "Something went wrong."))
                }
                is SocketTimeoutException, is SocketException -> {
                    emit(Resource.Error("Couldn't reach server at the moment"))
                }
            }
        }
    }
}
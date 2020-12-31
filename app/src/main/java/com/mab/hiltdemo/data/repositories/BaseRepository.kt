package com.mab.hiltdemo.data.repositories

import android.util.Log
import com.mab.hiltdemo.data.network.BaseResponse
import com.mab.hiltdemo.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    private val TAG = "BaseRepository"
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = Resource.Success(apiCall.invoke())
                val responseInfo = response.value as BaseResponse
                Log.e(TAG, "")
                if (!responseInfo.success) {
                    Resource.Failure(false, null, responseInfo.message, null)
                } else {
                    response
                }

            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> Resource.Failure(false, throwable.code(), null, throwable.response()?.errorBody())
                    else -> Resource.Failure(true, null, null, null)
                }
            }
        }
    }
}
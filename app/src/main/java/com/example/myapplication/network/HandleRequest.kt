package com.example.myapplication.network

import android.util.Log
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

private const val genericErrorMsg = "Something went wrong try again later!"
private const val networkErrorMsg = "Check your internet connection!"

suspend fun <T: Any> handleRequest(requestFunc: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(requestFunc.invoke())
    } catch (throwable: Throwable) {
        Log.e("Service Error",throwable.message?:"")
        when (throwable) {
            is UnknownHostException -> ResultWrapper.NetworkError(networkErrorMsg)
            is IOException -> ResultWrapper.NetworkError(networkErrorMsg)
            is HttpException -> {
                val code = throwable.code()
                ResultWrapper.GenericError(code, genericErrorMsg)
            }
            else -> {
                ResultWrapper.GenericError(null, genericErrorMsg)
            }
        }
    }
}
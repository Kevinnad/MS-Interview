package com.example.myapplication.network


sealed class ResultWrapper<out T>{
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Failure(val value: String): ResultWrapper<String>()
    data class GenericError(val code: Int? = null, val value: String): ResultWrapper<Nothing>()
    data class NetworkError(val value: String): ResultWrapper<Nothing>()
}
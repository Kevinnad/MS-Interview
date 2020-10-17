package com.example.myapplication.repositories

import com.example.myapplication.network.Services
import com.example.myapplication.network.handleRequest
import javax.inject.Inject

class ApiRepo @Inject constructor(private val services: Services) {

    suspend fun fetchList(since : Int) = handleRequest { services.getListApi(since) }
}
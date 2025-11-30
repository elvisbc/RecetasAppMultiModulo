package com.elvis.coreNetwork.cliente

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorCliente {

    fun obtenerInstancia(): HttpClient =HttpClient {
        install(ContentNegotiation){
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }
        install(DefaultRequest){
            url{
                host = "themealdb.com/api/json/"
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
        install(HttpTimeout){
            socketTimeoutMillis = 5000
            connectTimeoutMillis = 5000
            requestTimeoutMillis = 5000
        }
    }
}
package com.pg.homeworknetwork

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*



class Api {
    companion object Config {
        private const val BASE_URL = BuildConfig.API_BASE_URL
  	    private const val API_KEY  = BuildConfig.API_KEY
        private const val MOVIES = "/en/API/MostPopularMovies"
        private const val MOVIE = "/ru/API/Title"

    }

    private val client = HttpClient(Android) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }


    // https://imdb-api.com/en/API/MostPopularMovies/api_key
    suspend fun getMovies(): Movies = client.get(host = BASE_URL, path = "$MOVIES/$API_KEY")

    // https://imdb-api.com/ru/API/Title/api_key/tt9419884
    suspend fun getMovie(movieId: String): Movie =
        client.get(host = BASE_URL, path = "$MOVIE/$API_KEY/$movieId")

}

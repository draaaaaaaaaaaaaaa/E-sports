package com.daffa.test.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/games/e-sport")
    fun getEsport() : Call<List<EsportsResponseItem>>
}
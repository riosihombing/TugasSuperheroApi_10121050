/*
 * Project Name : TugasSuperheroAPI_10121050
 * Created by Rio
 * Copyright (c) 2024. All rights reserverd.
 * Last modified 7/14/24, 3:18 PM
 */
package com.rio.tugassuperheroapi_10121050

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // Endpoint untuk mendapatkan detail superhero berdasarkan ID
    @GET("api/7206709729358765/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperHeroDetailResponse>
}
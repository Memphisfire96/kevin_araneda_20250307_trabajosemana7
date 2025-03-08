package com.example.kevin_araneda_20250307_trabajosemana7

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("getLocalesTurnos.php")
    fun getFarmacias(): Call<List<Farmacia>>
}

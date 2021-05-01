package com.example.pruebaindividual2m4rodolfoparada
//Rodolfo Parada
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    //Obtiene informacion del api (seconecta con el api)
    @GET
    fun getConexionConApi(@Url url:String): Call<AnimalZResponse>
}


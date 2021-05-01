package com.example.pruebaindividual2m4rodolfoparada
//Rodolfo Parada
import com.google.gson.annotations.SerializedName


  data class AnimalZResponse (

    @SerializedName("status") var status:String
    ,@SerializedName("message") var images:List<String>

)

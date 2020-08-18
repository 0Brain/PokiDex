package com.prasan.pokiapp.network

import com.prasan.pokiapp.model.info.PokemonInfo
import com.prasan.pokiapp.model.main.PokemonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

 @GET("pokemon")
 suspend fun getPokemon(
  @Query("limit") limit:Int = 100,
  @Query("offset") offset:Int = 0
 ):Response<PokemonResponse>

 @GET("pokemon/{name}")
 fun getPokemonInfo(
  @Path("name") name:String
 ):Call<PokemonInfo>
}
package com.prasan.pokiapp.network

import com.prasan.pokiapp.model.Pokemon
import com.prasan.pokiapp.model.PokemonInfo
import com.prasan.pokiapp.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

 @GET("pokemon")
 fun getPokemon(
  @Query("limit") limit:Int = 10,
  @Query("offset") offset:Int = 0
 ):Call<PokemonResponse>

 @GET("pokemon/{name}")
 fun getPokemonInfo(
  @Path("name") name:String
 ):Call<PokemonInfo>
}
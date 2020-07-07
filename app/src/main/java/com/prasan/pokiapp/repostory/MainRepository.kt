package com.prasan.pokiapp.repostory

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasan.pokiapp.PokiApplication
import com.prasan.pokiapp.model.Pokemon
import com.prasan.pokiapp.model.PokemonResponse
import com.prasan.pokiapp.network.PokemonService
import com.prasan.pokiapp.persistance.PokemonDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(
 private val pokemonApi: PokemonService,
 private val pokemonDao: PokemonDao
) :Repository {

 fun fetchPokemonList(
  page:Int
 ):LiveData<List<Pokemon>> {
  val pokemonListDb = pokemonDao.getPokemonList(page)
  val pokemonListLiveData = MutableLiveData<List<Pokemon>>()
  if(pokemonListDb.isEmpty()){
   pokemonApi.getPokemon(page)
    .enqueue(object :Callback<PokemonResponse>{
     override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
      Timber.d("$t")
      Toast.makeText(PokiApplication.getContext(), "${t.message}", Toast.LENGTH_SHORT).show()
     }

     override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
      if(response.isSuccessful){
       val pokemonResponse:PokemonResponse? = response.body()
       pokemonDao.insertPokemonList(pokemonResponse!!.results)
       pokemonListLiveData.value = pokemonResponse.results
      }
     }
    })
  }else{
    pokemonListLiveData.value = pokemonListDb
  }
  return pokemonListLiveData
 }
}
package com.prasan.pokiapp.persistance.local.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasan.pokiapp.model.main.Pokemon
import com.prasan.pokiapp.network.PokemonApi
import com.prasan.pokiapp.repostory.PokemonRepository
import kotlinx.coroutines.*
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonDao: PokemonDao
    , private val pokemonApi: PokemonApi
) : PokemonRepository {

    override fun getPokemonList(): LiveData<List<Pokemon>> {
        val pokemonLiveData = MutableLiveData<List<Pokemon>>()
        GlobalScope.launch(Dispatchers.Main) {
            supervisorScope {
                val pokemonList = async(Dispatchers.IO) {
                    return@async pokemonDao.getPokemonList()
                }
                try {
                    pokemonLiveData.postValue(pokemonList.await())
                } catch (e: Exception) {
                    Timber.d("Erro! ${e.message}")
                }
            }
        }
        if (pokemonLiveData.value == null) {
            GlobalScope.launch(Dispatchers.IO) {
                val responsePokemon = pokemonApi.getPokemon()
                if(responsePokemon.isSuccessful){
                    pokemonLiveData.postValue(responsePokemon.body()!!.results)
                    pokemonDao.insertPokemonList(responsePokemon.body()!!.results)
                }else if (!responsePokemon.isSuccessful) {
                    Timber.d(responsePokemon.message())
                }
            }
            Timber.d(Thread.currentThread().name)
        } else {
            return pokemonLiveData
        }
        return pokemonLiveData
    }
}
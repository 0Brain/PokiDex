package com.prasan.pokiapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.prasan.pokiapp.model.main.Pokemon
import com.prasan.pokiapp.persistance.local.pokemon.PokemonRepositoryImpl
import com.prasan.pokiapp.repostory.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    fun getAllPokemon(): LiveData<List<Pokemon>> {
        return pokemonRepository.getPokemonList()
    }
}
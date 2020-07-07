package com.prasan.pokiapp.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prasan.pokiapp.model.Pokemon
import com.prasan.pokiapp.repostory.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(
 private val mainRepository: MainRepository
):ViewModel() {


 fun getAllPokemon(page:Int){
  viewModelScope.launch { 
    fetchPokemonList(page)
  }
 }

 private suspend fun fetchPokemonList(page: Int):LiveData<List<Pokemon>>  = withContext(Dispatchers.IO){
  return@withContext mainRepository.fetchPokemonList(page)
 }
}
package com.prasan.pokiapp.repostory

import androidx.lifecycle.LiveData
import com.prasan.pokiapp.model.main.Pokemon

interface PokemonRepository {
      fun getPokemonList():LiveData<List<Pokemon>>
}
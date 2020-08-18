package com.prasan.pokiapp.persistance.local.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.pokiapp.model.main.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemon: List<Pokemon>)

    /**
     * Get pokemon by page.
     *
     * @return the pokemon list from the table.
     */
    @Query("SELECT * FROM Pokemon")
    suspend fun getPokemonList(): List<Pokemon>

}
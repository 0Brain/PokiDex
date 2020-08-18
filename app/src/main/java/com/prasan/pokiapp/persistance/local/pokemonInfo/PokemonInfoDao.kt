package com.prasan.pokiapp.persistance.local.pokemonInfo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.pokiapp.model.info.PokemonInfo

@Dao
interface PokemonInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonInfo(pokemonInfo: PokemonInfo)

    @Query("SELECT * FROM PokemonInfo WHERE name =:name")
    suspend fun getPokemonInfo(name: String): PokemonInfo
}
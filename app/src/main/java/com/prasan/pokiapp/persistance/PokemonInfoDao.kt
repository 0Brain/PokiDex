package com.prasan.pokiapp.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.pokiapp.commons.BasePokemonDao
import com.prasan.pokiapp.model.PokemonInfo

@Dao
interface PokemonInfoDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertPokemonInfo(pokemonInfo:PokemonInfo)

 @Query("SELECT * FROM PokemonInfo WHERE name =:name")
  fun getPokemonInfo(name:String):PokemonInfo
}
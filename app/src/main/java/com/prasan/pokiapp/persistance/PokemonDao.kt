package com.prasan.pokiapp.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasan.pokiapp.commons.BasePokemonDao
import com.prasan.pokiapp.model.Pokemon

@Dao
interface PokemonDao {

 @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertPokemonList(pokemon: List<Pokemon>)

 /**
  * Get pokemon by page.
  *
  * @return the pokemon list from the table.
  */
 @Query("SELECT * FROM Pokemon WHERE page=:page_")
  fun getPokemonList(page_:Int):List<Pokemon>

}
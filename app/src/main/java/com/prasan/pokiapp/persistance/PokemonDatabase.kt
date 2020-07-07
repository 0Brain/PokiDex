package com.prasan.pokiapp.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasan.pokiapp.commons.BasePokemonDao
import com.prasan.pokiapp.converters.PokemonInfoTypeConverter
import com.prasan.pokiapp.converters.PokemonInfoTypeResponseConverter
import com.prasan.pokiapp.model.Pokemon
import com.prasan.pokiapp.model.PokemonInfo

@Database(entities = [Pokemon::class,PokemonInfo::class],version = 1)
@TypeConverters(value = [PokemonInfoTypeConverter::class,PokemonInfoTypeResponseConverter::class])
abstract class PokemonDatabase: RoomDatabase() {

 abstract fun pokemonDao():PokemonDao
 abstract fun pokemonInfoDao():PokemonInfoDao
}
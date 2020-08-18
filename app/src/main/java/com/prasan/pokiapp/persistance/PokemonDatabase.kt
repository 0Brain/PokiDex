package com.prasan.pokiapp.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasan.pokiapp.persistance.converters.PokemonInfoTypeConverter
import com.prasan.pokiapp.persistance.converters.PokemonInfoTypeResponseConverter
import com.prasan.pokiapp.model.main.Pokemon
import com.prasan.pokiapp.model.info.PokemonInfo
import com.prasan.pokiapp.persistance.local.pokemon.PokemonDao
import com.prasan.pokiapp.persistance.local.pokemonInfo.PokemonInfoDao

@Database(entities = [Pokemon::class, PokemonInfo::class],version = 1,exportSchema = false)
@TypeConverters(value = [PokemonInfoTypeConverter::class,PokemonInfoTypeResponseConverter::class])
abstract class PokemonDatabase: RoomDatabase() {

 abstract fun pokemonDao(): PokemonDao
 abstract fun pokemonInfoDao(): PokemonInfoDao
}
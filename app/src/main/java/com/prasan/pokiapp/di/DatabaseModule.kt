package com.prasan.pokiapp.di

import android.content.Context
import androidx.room.Room
import com.prasan.pokiapp.persistance.local.pokemon.PokemonDao
import com.prasan.pokiapp.persistance.PokemonDatabase
import com.prasan.pokiapp.persistance.local.pokemonInfo.PokemonInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

 @Singleton
 @Provides
 fun provideDatabase(@ApplicationContext context: Context):PokemonDatabase{
  return Room.databaseBuilder(context,PokemonDatabase::class.java,"pokemon.db")
   .fallbackToDestructiveMigration()
   .build()
 }

 @Singleton
 @Provides
 fun providePokemonDao(pokemonDatabase: PokemonDatabase): PokemonDao {
  return pokemonDatabase.pokemonDao()
 }

 @Singleton
 @Provides
 fun providePokemon(pokemonDatabase: PokemonDatabase): PokemonInfoDao {
  return pokemonDatabase.pokemonInfoDao()
 }

}
package com.prasan.pokiapp.di

import com.prasan.pokiapp.network.PokemonApi
import com.prasan.pokiapp.persistance.local.pokemon.PokemonDao
import com.prasan.pokiapp.persistance.local.pokemon.PokemonRepositoryImpl
import com.prasan.pokiapp.repostory.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object MainRepositoryModule {

 @Provides
 @Singleton
 fun provideMainRepository(
     pokemonApi: PokemonApi,
     pokemonDao: PokemonDao
 ): PokemonRepository {
  return PokemonRepositoryImpl(pokemonDao,pokemonApi)
 }
}
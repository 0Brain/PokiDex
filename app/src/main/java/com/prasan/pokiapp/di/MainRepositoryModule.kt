package com.prasan.pokiapp.di

import com.prasan.pokiapp.network.PokemonService
import com.prasan.pokiapp.persistance.PokemonDao
import com.prasan.pokiapp.repostory.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@Module
@InstallIn(ActivityRetainedComponent::class)
object MainRepositoryModule {

 @Provides
 @ActivityRetainedScoped
 fun provideMainRepository(
  pokemonApi: PokemonService,
  pokemonDao: PokemonDao
 ): MainRepository {
  return MainRepository(pokemonApi, pokemonDao)
 }
}
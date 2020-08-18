package com.prasan.pokiapp.di

import com.prasan.pokiapp.network.HttpRequestInterceptor
import com.prasan.pokiapp.network.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

 @Singleton
 @Provides
 fun provideOkHttp():OkHttpClient{
  return OkHttpClient
   .Builder()
   .addInterceptor(HttpRequestInterceptor())
   .build()
 }

 @Singleton
 @Provides
 fun provideRetrofitInstance(okHttpClient: OkHttpClient):Retrofit{
 return Retrofit
  .Builder()
  .client(okHttpClient)
  .baseUrl("https://pokeapi.co/api/v2/")
  .addConverterFactory(MoshiConverterFactory.create())
  .build()
 }

 @Singleton
 @Provides
 fun providePokemonApi(retrofit: Retrofit):PokemonApi{
  return retrofit.create(PokemonApi::class.java)
 }

// @Singleton
// @Provides
// fun providePokemonClient(pokemonApi: PokemonApi):PokemonClient{
//  return PokemonClient(pokemonApi)
// }

}
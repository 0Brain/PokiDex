package com.prasan.pokiapp.persistance.converters

import androidx.room.TypeConverter
import com.prasan.pokiapp.model.info.PokemonInfo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class PokemonInfoTypeResponseConverter {
 val moshi: Moshi by lazy {
  Moshi.Builder().build()
 }


 @TypeConverter
 fun fromTypeResponseToString(typeResponse:List<PokemonInfo.TypeResponse>):String{
  val listType = Types.newParameterizedType(List::class.java,
   PokemonInfo.TypeResponse::class.java)
  val adapter: JsonAdapter<List<PokemonInfo.TypeResponse>> = moshi.adapter(listType)
  return adapter.toJson(typeResponse)
 }

 @TypeConverter
 fun fromStringToTypeResponse(value:String):List<PokemonInfo.TypeResponse>?{
  val listType = Types.newParameterizedType(List::class.java,
   PokemonInfo.TypeResponse::class.java)
  val adapter: JsonAdapter<List<PokemonInfo.TypeResponse>> = moshi.adapter(listType)
  return adapter.fromJson(value)
 }
}

package com.prasan.pokiapp.converters

import androidx.room.TypeConverter
import com.prasan.pokiapp.model.PokemonInfo
import com.squareup.moshi.Moshi

class PokemonInfoTypeConverter {
 val moshi: Moshi by lazy {
  Moshi.Builder().build()
 }

 @TypeConverter
 fun fromTypeToString(type:PokemonInfo.Type):String{
  val adapter = moshi.adapter(PokemonInfo.Type::class.java)
  return adapter.toJson(type)
 }

 @TypeConverter
 fun fromStringToType(name:String):PokemonInfo.Type?{
  val adapter = moshi.adapter(PokemonInfo.Type::class.java)
  return adapter.fromJson(name)
 }
}
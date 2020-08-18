package com.prasan.pokiapp.model.info

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.random.Random


@Entity
@JsonClass(generateAdapter = true)
data class PokemonInfo(
 @Json(name = "id") @NonNull @PrimaryKey val id:String,
 @Json(name = "name") val name:String,
 @Json(name = "height") val height:Int,
 @Json(name = "weight") val weight:Int,
 @Json(name = "types") val types:List<TypeResponse>,
 val hp:Int = Random.nextInt(maxHp),
 val attack:Int = Random.nextInt(maxAttack),
 val defense:Int = Random.nextInt(maxDefense),
 val speed:Int = Random.nextInt(maxSpeed),
 val exp:Int = Random.nextInt(maxExp)
) {

 companion object {
  const val maxHp = 300
  const val maxAttack = 300
  const val maxDefense = 300
  const val maxSpeed = 300
  const val maxExp = 1000
 }

 fun getIdString():String = String.format("#%03d",id)
 fun getWeightString():String = String.format("%.1f KG",weight.toFloat()/10)
 fun getHeightString():String = String.format("%.1f M",height.toFloat()/10)
 fun getHpString():String = "$hp/$maxHp"
 fun getAttackString():String = "$attack/$maxAttack"
 fun getDefenseString():String = "$defense/$maxDefense"
 fun getSpeedString():String = "$speed/$maxSpeed"
 fun getExpString():String = "$exp/$maxExp"

 @JsonClass(generateAdapter = true)
 data class TypeResponse(
  @Json(name = "slot") val slot:Int,
  @Json(name = "type") val type: Type
 )
 @JsonClass(generateAdapter = true)
 data class Type(
  @Json(name = "name") val name:String
 )
}
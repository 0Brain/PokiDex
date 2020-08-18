
package com.prasan.pokiapp.model.main

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class Pokemon(
 val page:Int = 0,
 @Json(name = "name") @NonNull @PrimaryKey val id:String,
 @Json(name = "url") val imageUrl:String
): Parcelable{

 fun getImageFromUrl():String{
  val index: String = imageUrl.split("/".toRegex()).dropLast(1).last()
  return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
 }
}

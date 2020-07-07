
package com.prasan.pokiapp.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
@Parcelize
data class Pokemon(
 var page: Int = 0,
 @field:Json(name = "name") @NonNull @PrimaryKey val id:String,
 @field:Json(name = "url") val imageUrl:String
): Parcelable{

 fun getImageFromUrl():String{
  val index: String = imageUrl.split("/".toRegex()).dropLast(1).last()
  return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
 }
}

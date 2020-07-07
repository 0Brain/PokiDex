package com.prasan.pokiapp.commons

import androidx.room.Insert
import androidx.room.OnConflictStrategy


interface BasePokemonDao<T> {

 /**
  * Insert an object in the database.
  *
  * @param obj the object to be inserted.
  */
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun insert(obj: T)

 /**
  * Insert an array of objects in the database.
  *
  * @param obj the objects to be inserted.
  */
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun insertMultiple(obj:List<T>)

}
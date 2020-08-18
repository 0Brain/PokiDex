
package com.prasan.pokiapp

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokiApplication : Application(){
 companion object{
  private var context: Context? = null
  fun getContext(): Context? {
   return PokiApplication.context
  }
 }
 override fun onCreate() {
  super.onCreate()
  PokiApplication.context = applicationContext;
  Stetho.initializeWithDefaults(this);
 }
}

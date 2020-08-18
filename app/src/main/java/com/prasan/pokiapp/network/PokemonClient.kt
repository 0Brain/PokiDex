//package com.prasan.pokiapp.network
//
//import android.widget.Toast
//import com.prasan.pokiapp.PokiApplication
//import com.prasan.pokiapp.model.info.PokemonInfo
//import com.prasan.pokiapp.model.main.PokemonResponse
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import timber.log.Timber
//import javax.inject.Inject
//
//class PokemonClient @Inject constructor(private val pokemonApi: PokemonApi) {
//
// companion object{
//  private const val pagingSize = 20
// }
//
// suspend fun fetchPokemonList(
//  page:Int,
//  onResult: (response: Callback<PokemonResponse>) -> Unit
// ){
//  pokemonApi.getPokemon(
//     limit = pagingSize,
//     offset = page * 3
//  ).enqueue(object :Callback<PokemonResponse>{
//   override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
//    Timber.d("$t")
//    Toast.makeText(PokiApplication.getContext(), "$t", Toast.LENGTH_SHORT).show()
//   }
//
//   override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
//    if(response.isSuccessful){
//     val pokemonResponse:PokemonResponse? = response.body()
//    }
//   }
//
//  })
// }
//
// suspend fun fetchPokemonInfo(
//  name:String,
//  onResult: (response: Callback<PokemonInfo>) -> Unit
// ){
//  pokemonApi.getPokemonInfo(
//   name = name
//  )
// }
//}
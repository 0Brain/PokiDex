package com.prasan.pokiapp.ui.detail

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.prasan.pokiapp.R
import com.prasan.pokiapp.model.info.PokemonInfo
import com.prasan.pokiapp.model.main.Pokemon
import com.prasan.pokiapp.network.PokemonApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    @Inject lateinit var pokemonApi: PokemonApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val pokemon: Pokemon? = intent.getParcelableExtra("pokemon")
        val imageUrl = pokemon!!.getImageFromUrl()
        name.text = pokemon.id
        Glide.with(this)
            .load(imageUrl)
            .listener(
                GlidePalette.with(imageUrl)
                .use(BitmapPalette.Profile.MUTED_LIGHT)
                .intoCallBack{
                    val rgb = it?.dominantSwatch?.rgb
                    if (rgb!=null){
                        header.setBackgroundColor(rgb)
                    }
                }.crossfade(true))
            .into(image)

        pokemonApi.getPokemonInfo(pokemon.id).enqueue(object : Callback<PokemonInfo>{
            override fun onFailure(call: Call<PokemonInfo>, t: Throwable) {
                Timber.d(t)
            }

            override fun onResponse(call: Call<PokemonInfo>, response: Response<PokemonInfo>) {
                val pokemonbody = response.body()
                Timber.d("$pokemonbody")
                height.text = pokemonbody!!.getHeightString()
                weight.text = pokemonbody.getWeightString()
                progress_hp.setProgressCompat(pokemonbody.hp,false)

            }

        })
    }
}
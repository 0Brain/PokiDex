package com.prasan.pokiapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView
import com.prasan.pokiapp.R
import com.prasan.pokiapp.model.main.Pokemon
import com.prasan.pokiapp.ui.detail.DetailsActivity

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

 private  var pokemonList:List<Pokemon> = ArrayList()

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
  val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent,false)
 return PokemonViewHolder(view)
 }

 override fun getItemCount(): Int {
  return pokemonList.size
 }

 fun setPokemonList(pokemonList:List<Pokemon>){
   this.pokemonList = pokemonList
  notifyDataSetChanged()
 }

 override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
  holder.bindItems(pokemonList[position])
  holder.itemView.setOnClickListener{
   val context: Context = it!!.context
   val intent = Intent(context, DetailsActivity::class.java)
   val pokemon:Pokemon = pokemonList[position]
   intent.putExtra("pokemon",pokemon)
   context.startActivity(intent)
  }
 }

 class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  fun bindItems(pokemonItem:Pokemon){
   val pokemonImage = itemView.findViewById(R.id.im_pokemon) as ImageView
   val pokemonName = itemView.findViewById(R.id.tv_name) as TextView
   val pokemonCard = itemView.findViewById(R.id.pokemon_card_view) as  MaterialCardView


   pokemonName.text = pokemonItem.id
   val imageUrl = pokemonItem.getImageFromUrl()
   Glide.with(itemView)
    .load(imageUrl)
    .listener(GlidePalette.with(imageUrl)
     .use(BitmapPalette.Profile.MUTED_LIGHT)
     .intoCallBack{
      val rgb = it?.dominantSwatch?.rgb
      if (rgb!=null){
       pokemonCard.setCardBackgroundColor(rgb)
      }
     }.crossfade(true))
    .into(pokemonImage)
  }
 }
}
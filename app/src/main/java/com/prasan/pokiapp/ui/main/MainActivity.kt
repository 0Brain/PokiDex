package com.prasan.pokiapp.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.prasan.pokiapp.R
import com.prasan.pokiapp.ui.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: PokemonAdapter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mLayoutManager: StaggeredGridLayoutManager

    //Hilt ViewModel Injection
    private val noteViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById<RecyclerView>(R.id.rv_pokemon)
        mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.setHasFixedSize(true)
        mAdapter = PokemonAdapter()
        noteViewModel.getAllPokemon().observe(this, Observer {
            mAdapter.setPokemonList(it)
        })
        mRecyclerView.adapter = mAdapter
    }
}

package com.example.recyclerviewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewanimation.adapter.RvAdapter
import com.example.recyclerviewanimation.adapter.itemHelper
import com.example.recyclerviewanimation.databinding.ActivityMainBinding
import com.example.recyclerviewanimation.model.Constants
import com.example.recyclerviewanimation.model.Movie

class MainActivity : AppCompatActivity() {
    private val rvAdapter by lazy { RvAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        itemHelper.attachToRecyclerView(binding.rv)

        binding.rv.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        uploadData()
    }

    private fun uploadData(){
        rvAdapter.movieList = Constants.addMovies()
    }
}
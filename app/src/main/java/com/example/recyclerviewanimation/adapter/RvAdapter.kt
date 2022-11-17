package com.example.recyclerviewanimation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.R
import com.example.recyclerviewanimation.databinding.ActivityMainBinding
import com.example.recyclerviewanimation.databinding.ItemLayoutBinding
import com.example.recyclerviewanimation.model.Movie

class RvAdapter: RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    private lateinit var context: Context
    var movieList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        context = parent.context
        return RvViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(movieList[position])
        holder.itemView.animation = AnimationUtils.loadAnimation(context, R.anim.anim_1)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun moveItem(from: Int, to: Int){
        val currentList = movieList
        val fromLocation = currentList[from]
        if(to < from){
            currentList.add(to + 1, fromLocation)
        } else{
            currentList.add(to - 1, fromLocation)
        }
        movieList = currentList
    }

    inner class RvViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.apply {
                itemImage.setImageResource(movie.image)
                itemName.text = movie.name
                itemInfo.text = movie.info
                itemTime.text = movie.time.toString()
                itemRating.text = movie.rating.toString()
            }
        }
    }
}
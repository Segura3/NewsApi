package com.seguras.newsapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.seguras.newsapi.databinding.ItemArticuloBinding
import com.squareup.picasso.Picasso

class ResultadoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemArticuloBinding.bind(view)

    fun bind(item: Resultado){
        with(binding){
            tvTitle.text = item.title
            tvDate.text = item.published_date
            if(item.media.isEmpty()){
                binding.ivFoto.setImageResource(R.drawable.nytlogo)
            }else{
                Picasso.get().load(item.media.first().metadata.first().urlmetadata).into(binding.ivFoto)
            }
        }
    }
}
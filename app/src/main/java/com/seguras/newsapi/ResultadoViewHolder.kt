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
            //tvUrl.text = item.url
            Picasso.get().load(item.media[0].metadata[0].urlmetadata).into(binding.ivFoto)
        }
    }
}
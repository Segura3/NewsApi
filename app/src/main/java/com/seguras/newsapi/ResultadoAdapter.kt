package com.seguras.newsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ResultadoAdapter(val articulos: List<Resultado>, private val onResClickListener: OnResClickListener): RecyclerView.Adapter<ResultadoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultadoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ResultadoViewHolder(layoutInflater.inflate(R.layout.item_articulo, parent, false))
    }

    override fun onBindViewHolder(holder: ResultadoViewHolder, position: Int) {
        val item = articulos[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            onResClickListener.onResItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return articulos.size
    }
}
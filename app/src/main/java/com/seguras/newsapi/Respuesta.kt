package com.seguras.newsapi

data class Respuesta(var status: String,
                     var copyright: String,
                     var num_results: Int,
                     var results: List<Resultado>)

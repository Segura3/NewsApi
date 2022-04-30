package com.seguras.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.seguras.newsapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnResClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ResultadoAdapter
    private var articulos = mutableListOf<Resultado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        getMostPopular()

    }

    fun getMostPopular(){
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<Respuesta> = getRetrofit().create(APIService::class.java).getResponse("emailed/7.json?api-key=PAUroK6hddHNbFxmvPI6uap19qAcgsXF")
            val respuesta: Respuesta? = call.body()
            val art: List<Resultado> = respuesta?.results ?: emptyList()
            runOnUiThread {
                if (call.isSuccessful) {
                    articulos.clear()
                    articulos.addAll(art)
                    adapter.notifyDataSetChanged()
                } else {
                    //showError()
                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initRecyclerView(){
        adapter = ResultadoAdapter(articulos, this)
        binding.rvArticulos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvArticulos.adapter = adapter

    }

    override fun onResItemClicked(position: Int){
        //Toast.makeText(this, articulos[position].title, Toast.LENGTH_SHORT).show()
        binding.wvPagina.loadUrl(articulos[position].url)
    }
}
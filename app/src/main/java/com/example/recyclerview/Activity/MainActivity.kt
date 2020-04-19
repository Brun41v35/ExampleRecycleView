package com.example.recyclerview.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.BebidasAdapter
import com.example.recyclerview.Model.Bebidas
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var bebidasStr = arrayOf("Café", "Leite", "Chocolate", "Café com leite")
    var bebidasImg = arrayOf(R.drawable.cafe, R.drawable.leite, R.drawable.chocolate, R.drawable.cafe)

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        criarListaBebidas(carregaModeloBebidas(bebidasImg, bebidasStr))
    }

    fun criarListaBebidas(bebidas: ArrayList<Bebidas>){
        viewManager = LinearLayoutManager(this)
        viewAdapter = BebidasAdapter(bebidas) { texto -> bebidasItemClicked(texto)}

        rv_lista_bebidas.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        rv_lista_bebidas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun bebidasItemClicked(bebida: Bebidas) {
        Toast.makeText(this, "Escolhi: ${bebida.nome}", Toast.LENGTH_SHORT).show()
    }

    fun carregaModeloBebidas(imagens: Array<Int>, nomes: Array<String>): ArrayList<Bebidas> {
        var bebidas: ArrayList<Bebidas> = ArrayList<Bebidas>()
        for (i in imagens.indices) {
            val bebida = Bebidas(imagens[i], nomes[i])
            bebidas.add(bebida)
        }
        return bebidas;
    }
}

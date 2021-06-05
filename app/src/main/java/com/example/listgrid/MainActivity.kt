package com.example.listgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var objeto: ArrayList<Objeto> = ArrayList()

        objeto.add(Objeto("My Hero Academia",R.drawable.mha,"Anime Shonen - Superhéroes"))
        objeto.add(Objeto("Fullmetal Alchemist",R.drawable.fmab, "Anime Shonen"))
        objeto.add(Objeto("Spectacular Spider-Man",R.drawable.ssm, "Cartoon"))
        objeto.add(Objeto("Jujutsu Kaisen",R.drawable.jjk, "Anime Shonen - Peleas"))
        objeto.add(Objeto("Demon Slayer",R.drawable.knyl, "Anime Shonen"))

        val lista = findViewById<ListView>(R.id.list)
        val adaptador = AdaptadorCustom(this,objeto)
        lista.adapter = adaptador
        lista.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, objeto.get(position).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.listgrid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustom(var context:Context, items:ArrayList<Objeto>): BaseAdapter() {

    var items:ArrayList<Objeto>? = items

    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder? = null
        var vista: View? = convertView
        if (vista == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        } else {
            holder = vista.tag as? ViewHolder
        }

        var item = getItem(position) as Objeto
        holder?.nombre?.text = item.nombre
        holder?.descripcion?.text = item.descripcion
        holder?.img?.setImageResource(item.img)

        return vista!!
    }

    private class ViewHolder(view: View){
        var nombre: TextView? = null
        var img: ImageView? = null
        var descripcion: TextView? = null
        init {
            this.img = view.findViewById(R.id.imageView2)
            this.nombre = view.findViewById(R.id.nombre)
            this.descripcion = view.findViewById(R.id.descripcion)
        }
    }
}
package com.example.diego.laboratorio4navdrawer

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProjectAdapter(var context: Context, var list:ArrayList<Project>): BaseAdapter() {
    //Adapter para la listview de los proyectos
    private class ViewHolder(row: View?){//Adapta la posición como columna
        var txtName: TextView
        var txtLink: TextView//TextViews para el nombre que va arriba y el link del repositorio abajo.

        init {//Inicializa los datos annteriores como textViews
            this.txtName = row?.findViewById(R.id.name) as TextView
            this.txtLink = row?.findViewById(R.id.link) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {//Se obtiene la vista
        var view: View?
        var viewHolder: ViewHolder
        if (convertView==null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.activity_list,convertView,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }
        else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var objeto:Project = getItem(position) as Project//Obtiene cada uno de los objetos de Tipo Proyecto para mostrarlos en la lista

        viewHolder.txtName.text = objeto.name
        viewHolder.txtLink.text = (objeto.link)

        return view as View//FInal mente se retorna la vista y se muestra en el fragmento

    }

    override fun getItem(position: Int): Any {
        return list.get(position)//Esta función se utliza para obtener el la posición del elemento
    }

    override fun getItemId(position: Int): Long {//Obtener el ID
        return position.toLong();
    }

    override fun getCount(): Int {
        return list.count()//Indica la cantidad de elementos en la lista
    }
}
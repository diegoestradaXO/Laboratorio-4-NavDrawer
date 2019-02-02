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
    private class ViewHolder(row: View?){
        var txtName: TextView
        var txtLink: TextView

        init {
            this.txtName = row?.findViewById(R.id.name) as TextView
            this.txtLink = row?.findViewById(R.id.link) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
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

        var objeto:Project = getItem(position) as Project

        viewHolder.txtName.text = objeto.name
        viewHolder.txtLink.text = (objeto.link)

        return view as View

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
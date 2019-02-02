package com.example.diego.laboratorio4navdrawer.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.diego.laboratorio4navdrawer.Project
import com.example.diego.laboratorio4navdrawer.ProjectAdapter

import com.example.diego.laboratorio4navdrawer.R
import kotlinx.android.synthetic.main.fragment_projects.*
import com.example.diego.laboratorio4navdrawer.WebViewActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProjectsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        //Creamos la lista con los repositorios

        val view = inflater.inflate(R.layout.fragment_projects, container, false)
        return  view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val project1 = Project(
            "Proyecto de App Restaurante",
            "https://github.com/diegoestradaXO/Restaurant-Menu-Lab2"
        )
        val project2 = Project(
            "Proyecto para App de Contactos",
            "https://github.com/diegoestradaXO/App-de-Contactos---Lab3"
        )
        val list: ArrayList<Project> =  ArrayList()
        list.add(project1)
        list.add(project2)
        //Utiliza el modelo de adapter creado y se asigna a la lista de repositorios en el archivo xml
        repository_list.adapter = ProjectAdapter(context!!,list)

        //En caso de seleccionar cualquier repositorio dentro de la lista, se abrira un webview con el repositorio seleccionado
        repository_list.setOnItemClickListener { parent, view, position, id ->
            val intento = Intent(context!!, WebViewActivity::class.java)//Se abre la actividad del WebView
            intento.putExtra("link",list[position].link)//Se le manda como parametro extra el link del repositorio a leer
            startActivity(intento)
        }

    }

}

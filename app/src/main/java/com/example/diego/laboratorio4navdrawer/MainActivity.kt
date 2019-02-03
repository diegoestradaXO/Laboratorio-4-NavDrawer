package com.example.diego.laboratorio4navdrawer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.diego.laboratorio4navdrawer.Fragments.DirectionFragment
import com.example.diego.laboratorio4navdrawer.Fragments.HomeFragment
import com.example.diego.laboratorio4navdrawer.Fragments.ProjectsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        LoadFragment(HomeFragment())//Se carga e inicializa el fragmento de Inicio, foto y nombre
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_inicio -> {//Fragment de inicio, abre pantalla con foto y  nombre
                LoadFragment(HomeFragment())
            }
            R.id.nav_proyectos -> {//Fragmento de proyectos, abre pantalla con dos repositorios propios y usa webview
                LoadFragment(ProjectsFragment())
            }
            R.id.nav_direction -> {//Fragmento de mapa, abre una vista de mapa de Guatemala
                val intent = Intent(applicationContext, MapsActivity::class.java)
                startActivity(intent)//Se carga la Activity de Mapa
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun LoadFragment(fragment: Fragment) {//Se utiliza para cargar los fragmentos que estan en el Navigation Drawer
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.fragment_container , fragment).commit()
    }
}

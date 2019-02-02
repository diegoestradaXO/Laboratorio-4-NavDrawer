package com.example.diego.laboratorio4navdrawer


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.diego.laboratorio4navdrawer.R.id.home
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    //Activity que se encarga de abrir el repositorio deseado
    var mywebview: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        mywebview = findViewById<WebView>(R.id.vista)//Se obtiene el id del elemento previamente seleccionado
        mywebview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)//Se carga la vista con el url
                return true
            }
        }
        mywebview!!.loadUrl(getIntent().getStringExtra("link"))//Se utliiza el extra enviado en el fragmento Project

    }
}
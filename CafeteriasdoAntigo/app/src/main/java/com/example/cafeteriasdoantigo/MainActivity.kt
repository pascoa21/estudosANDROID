package com.example.cafeteriasdoantigo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.PkRSS
import com.pkmmte.pkrss.Callback

class MainActivity : AppCompatActivity(), Callback {

    lateinit var listView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>
    val listitens = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = LinearLayoutManager(this)
        listView = findViewById(R.id.recycleView) as RecyclerView
        listView.layoutManager = layout

        adapter = ItemAdapter(listitens, this)
        listView.adapter = adapter

        PkRSS.with(this).load(getString(R.string.site_iati)).callback(this).async()
    }

    override fun onLoaded(newArticles: MutableList<Article>?){
        listitens.clear()
        newArticles?.mapTo(listitens){
            Item(it.title, it.author, it.date, it.source, it.enclosure.url)
        }
        //adapter = ItemAdapter(listitens,this)
        adapter.notifyDataSetChanged()
    }
    override fun onLoadFailed(){

    }
    override fun onPreload(){

    }

    data class Item (val titulo:String, val autor: String, val data: Long, val link: Uri, val imagem: String)
}

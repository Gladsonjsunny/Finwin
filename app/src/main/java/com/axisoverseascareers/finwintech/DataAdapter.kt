package com.axisoverseascareers.finwintech

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private var moviesList: List<Datamodel>) :
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {



    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var url: TextView = view.findViewById(R.id.url)
        var thumburl: TextView = view.findViewById(R.id.thumburl)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var intent : Intent
        val context=holder.title.context
        val movie = moviesList[position]
        holder.title.text = movie.getTitle()
        holder.url.text = movie.getUrl()
        holder.thumburl.text = movie.getThumbnailurl()

        holder.itemView.setOnClickListener {
         intent  = Intent(it.context,SecondActivity::class.java)
           context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }
}


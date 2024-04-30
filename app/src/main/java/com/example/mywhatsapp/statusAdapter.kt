package com.example.mywhatsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mywhatsapp.statusAdapter.statusViewHolder
import de.hdodenhof.circleimageview.CircleImageView

class statusAdapter(var context : Activity, var arraylist :ArrayList<statususer>):
RecyclerView.Adapter<statusViewHolder>(){
    class statusViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val photo = ItemView.findViewById<CircleImageView>(R.id.photo)
        val name = ItemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): statusViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.statuscustom,parent,false)
        return statusViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    override fun onBindViewHolder(holder: statusViewHolder, position: Int) {
        holder.photo.setImageResource(arraylist[position].photo)
        holder.name.text=arraylist[position].name
    }

}
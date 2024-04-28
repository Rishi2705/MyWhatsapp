package com.example.mywhatsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywhatsapp.commonbaseadapter.commonViewHolder
import java.security.AccessControlContext

class commonbaseadapter(val context: Activity,val arrayList: ArrayList<commonuser>):
RecyclerView.Adapter<commonViewHolder>() {
    class commonViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val img = ItemView.findViewById<ImageView>(R.id.img)
        val txt = ItemView.findViewById<TextView>(R.id.txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commonViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.commonbasecustom,parent,false)
        return commonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: commonViewHolder, position: Int) {
        holder.img.setImageResource(arrayList[position].img)
        holder.txt.text = arrayList[position].txt
    }


}
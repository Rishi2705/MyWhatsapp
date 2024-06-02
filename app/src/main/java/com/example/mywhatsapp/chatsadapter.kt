package com.example.mywhatsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywhatsapp.chatsadapter.chatsViewHolder
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class chatsadapter(val context: Activity, val arrayList: List<User>) :
    RecyclerView.Adapter<chatsViewHolder>() {
    class chatsViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val photo = ItemView.findViewById<CircleImageView>(R.id.photo)
        val name = ItemView.findViewById<TextView>(R.id.name)
        val lst_msg = ItemView.findViewById<TextView>(R.id.lst_msg)
        val time = ItemView.findViewById<TextView>(R.id.time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatsViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.chatscustom,parent,false)
        return chatsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: chatsViewHolder, position: Int) {
        Picasso.get().load(arrayList[position].image).into(holder.photo)
        holder.name.text=arrayList[position].firstName
        holder.lst_msg.text=arrayList[position].domain
        holder.time.text=arrayList[position].phone
    }

}
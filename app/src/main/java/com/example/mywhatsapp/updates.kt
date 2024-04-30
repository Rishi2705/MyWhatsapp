package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class updates : AppCompatActivity() {
    lateinit var statusal : ArrayList<statususer>
    lateinit var channelsal : ArrayList<chatsuser>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updates)
        val rv1 = findViewById<RecyclerView>(R.id.rv1)
        rv1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        val photo = intArrayOf(R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon)
        val name = arrayOf("Friend 1","Friend 2","Friend 3","Friend 4","Friend 5","Friend 6","Friend 7","Friend 8","Friend 9","Friend 10")
        statusal = ArrayList()
        for (i in name.indices){
            val user = statususer(photo[i],name[i])
            statusal.add(user)
        }
        val rv2 = findViewById<RecyclerView>(R.id.rv2)
        rv2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        val photo1 = intArrayOf(R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon)
        val name1 = arrayOf("Friend 1","Friend 2","Friend 3","Friend 4","Friend 5","Friend 6","Friend 7","Friend 8","Friend 9","Friend 10")
        val lst_msg = arrayOf("Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!")
        val time = arrayOf("11:09 am","11:08 am","11:07 am","11:06 am","11:05 am","11:04 am","11:03 am","11:02 am","11:01 am","11:00 am")
        channelsal = ArrayList()
    }
}
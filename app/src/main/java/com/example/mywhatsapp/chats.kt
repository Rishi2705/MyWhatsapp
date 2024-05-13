package com.example.mywhatsapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import de.hdodenhof.circleimageview.CircleImageView


class chats : AppCompatActivity() {
    lateinit var al1: ArrayList<chatsuser>
    lateinit var al2: ArrayList<commonuser>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chats)
        val rv1 = findViewById<RecyclerView>(R.id.rv1)
        rv1.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val photo = intArrayOf(R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon)
        val name = arrayOf("Friend 1","Friend 2","Friend 3","Friend 4","Friend 5","Friend 6","Friend 7","Friend 8","Friend 9","Friend 10")
        val lst_msg = arrayOf("Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!")
        val time = arrayOf("11:09 am","11:08 am","11:07 am","11:06 am","11:05 am","11:04 am","11:03 am","11:02 am","11:01 am","11:00 am")
        al1 = arrayListOf()
        for(i in photo.indices){
            val User1 = chatsuser(photo[i],name[i],lst_msg[i],time[i])
            al1.add(User1)
        }
        rv1.adapter = chatsadapter(this,al1)
        val rv2 = findViewById<RecyclerView>(R.id.rv2)
        rv2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val img = intArrayOf(R.drawable.chatsicon,R.drawable.updatesicon,R.drawable.communitiesicon,R.drawable.callsicon)
        val txt = arrayOf("Chats","Updates","Communities","Calls")
        al2 = arrayListOf()
        for (i in txt.indices){
            val User2 = commonuser(img[i],txt[i])
            al2.add(User2)
        }
        rv2.adapter = commonbaseadapter(this,al2)

        val appmenu = findViewById<CircleImageView>(R.id.appmenu)
        appmenu.isClickable = true
        appmenu.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setTitle("this")
                .setMessage("Hello")
                .setNeutralButton("cancel"){ dialog, which ->
                }
                .setPositiveButton("yes"){dialog, which ->
                }
            val alertDialog = builder.create()
            alertDialog.show()
            alertDialog.setCancelable(true)
            val pDialog = SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE)
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"))
            pDialog.setTitleText("Loading")
            pDialog.setCancelable(false)
            
            pDialog.show()
        }
    }
}
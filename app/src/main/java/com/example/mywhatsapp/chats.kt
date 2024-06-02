package com.example.mywhatsapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class chats : AppCompatActivity() {
    private lateinit var urladress:String
    //lateinit var al1: ArrayList<chatsuser>
   //lateinit var al2: ArrayList<commonuser>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chats)
        //val rv1 = findViewById<RecyclerView>(R.id.rv1)
        //rv1.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        /*val photo = intArrayOf(R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon,R.drawable.dpicon)
        val name = arrayOf("Friend 1","Friend 2","Friend 3","Friend 4","Friend 5","Friend 6","Friend 7","Friend 8","Friend 9","Friend 10")
        val lst_msg = arrayOf("Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!","Hi!")
        val time = arrayOf("11:09 am","11:08 am","11:07 am","11:06 am","11:05 am","11:04 am","11:03 am","11:02 am","11:01 am","11:00 am")
        al1 = arrayListOf()
        for(i in photo.indices){
            val User1 = chatsuser(photo[i],name[i],lst_msg[i],time[i])
            al1.add(User1)
        }*/
       urladress = "https://dummyjson.com/"
       val retrofitbuilder  = Retrofit.Builder()
           .baseUrl(urladress)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(API::class.java)
       val retrofitData = retrofitbuilder.getUserData()
       retrofitData.enqueue(object :Callback<PluginDataClass?>{
           override fun onResponse(p0: Call<PluginDataClass?>, p1: Response<PluginDataClass?>) {
               val responseBody = p1.body()
               val userList = responseBody?.users!!

               var chatsadapter = chatsadapter(this@chats,userList)
               val rv1 = findViewById<RecyclerView>(R.id.rv1)
               rv1.adapter = chatsadapter
               rv1.layoutManager= LinearLayoutManager(this@chats)
           }

           override fun onFailure(p0: Call<PluginDataClass?>, p1: Throwable) {
           }
       })
        //rv1.adapter = chatsadapter(this,al1)
        /*val rv2 = findViewById<RecyclerView>(R.id.rv2)
        rv2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val img = intArrayOf(R.drawable.chatsicon,R.drawable.updatesicon,R.drawable.communitiesicon,R.drawable.callsicon)
        val txt = arrayOf("Chats","Updates","Communities","Calls")
        al2 = arrayListOf()
        for (i in txt.indices){
            val User2 = commonuser(img[i],txt[i])
            al2.add(User2)
        }
        rv2.adapter = commonbaseadapter(this,al2)*/

        val appmenu = findViewById<CircleImageView>(R.id.appmenu)
        appmenu.isClickable = true
        appmenu.setOnClickListener {
            /*val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setTitle("this")
                .setMessage("Hello")
                .setNeutralButton("cancel"){ dialog, which ->
                }
                .setPositiveButton("yes") { dialog, which ->
                }*/
            val alertDialog =AlertDialog.Builder(this)
                .setTitle("ARE YOU SURE ")
                .setPositiveButton("Yes"){
                        dialog, which ->
                }
                .setNegativeButton("No"){dialog, which ->
                }
                .setNeutralButton("Cancel"){dialog, which ->}
            val btn = alertDialog.create()
            btn.show()

            /*val pDialog = SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE)
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"))
            pDialog.setTitleText("Loading")
            pDialog.setCancelable(false)
            pDialog.show()*/
        }
    }
}
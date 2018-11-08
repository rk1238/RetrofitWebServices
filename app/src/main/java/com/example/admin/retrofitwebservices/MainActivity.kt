package com.example.admin.retrofitwebservices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.admin.retrofitwebservices.Modal.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var tv1:TextView?=null
    var et1:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1=findViewById(R.id.tv1)
        et1=findViewById(R.id.et1)

    }

    fun postlistData(view:View)
    {


        var retrofit=Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()
        var jsonPlaceHolder=retrofit.create(JsonPlaceHolder::class.java)
        var cal=jsonPlaceHolder.getPosts(et1?.text.toString());


        cal.enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"something error"+t.localizedMessage,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                var result=response.body()
                if (result != null) {
                    for (po in result) {
                        var re="id:"+po.id.toString()
                        re+="\n userId:"+po.userId+"\n";
                        re+="\n title:"+po.title+"\n";
                        re+="\n body:"+po.body+"\n";
                        tv1?.append(re)
                    }
                }

            }

        })

    }

    fun dbData(view: View)
    {
        var retrofit=Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()
        var jsonPlaceHolder=retrofit.create(JsonPlaceHolder::class.java)
        var call=jsonPlaceHolder.dataGetData()
        call.enqueue(object : Callback<DataGetData> {
            override fun onFailure(call: Call<DataGetData>, t: Throwable) {
               Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DataGetData>, response: Response<DataGetData>) {
               var fresult=response.body()
                var postresult=fresult?.postof
                var commentresult=fresult?.commants
                var profilemy=fresult?.profile
                if (postresult != null) {
                    for(posts in postresult) {
                        var putresult="\t\t\t\t\t\t\t\t"+profilemy?.name+"\n ";
                        putresult+="ID:"+posts.id.toString()+"\t\t\t\t"
                        putresult+="TITLE:"+posts.title.toString()+"\n"

                        tv1?.append(putresult)
                    }
                }
                if (commentresult != null) {
                    for(comments in commentresult) {
                        var putcomreslt="\n"
                        putcomreslt+="ID:\t\t\t\t"+comments.id.toString()
                        putcomreslt+="\nBODY:\t\t\t\t"+comments.body+"\n"
                        putcomreslt+="POSTID:\t\t\t\t"+comments.postId

                        tv1?.append(putcomreslt)
                    }
                }

            }

        })

    }
}

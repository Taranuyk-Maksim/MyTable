package com.pupsik.mytable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class MainActivity : AppCompatActivity() {

    val list = ArrayList<Lesson>()

    val json : String = "{ \"lessons\" : [ { \"lesson1\" : { \"time\" : \"10.00 - 11.20\", \"lessonsName\" : \"Розробка мобыльних ПЗ\", \"auditory\" : \"101 р\", \"type\" : \"лекция\", \"professors\" : \"Головань К.В.\" }}}"

    fun ParseJs(){
        val jsonObject = JSONObject(json)
        val jsonArray : JSONArray = jsonObject.getJSONArray("lesson1")
        val less: JSONObject = jsonArray.getJSONObject(0)

        var time = less.getString("time")
        var lesson = less.getString("lessonsName")

        list.add(Lesson(time,lesson,"fsdf","fsdljfds","fdsfdslfjds"))

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        ParseJs()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayView: RecyclerView = findViewById(R.id.lessons_of_day)
        dayView.layoutManager = LinearLayoutManager(this)
        dayView.adapter = LessonAdapter(list)

    }
}


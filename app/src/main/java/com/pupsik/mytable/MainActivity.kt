package com.pupsik.mytable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    fun getStringFromJsonFile() : String{
        var jsonStrng : String
        try{
            val ips : InputStream = resources.openRawResource(R.raw.day)
            val size = ips.available()
            val buffer = ByteArray(size)
            ips.read(buffer)
            ips.close()
            jsonStrng = String(buffer, Charsets.UTF_8)

        }catch (ex : IOException ){
            ex.printStackTrace()
            return "IOException"
        }
        return jsonStrng
    }

    fun createDay(jsArray: JSONArray) : ArrayList<Lesson>{

        val  day  = ArrayList<Lesson> ()

        for(n in 0 until jsArray.length()) {
            val less: JSONObject = jsArray.getJSONObject(n)
            day.add(Lesson(
                less.getString("time"),
                less.getString("lessonsName"),
                less.getString("auditory"),
                less.getString("type"),
                less.getString("professors")))
        }
        return day
    }

    fun parseJsonToJSONArray(json : String) : JSONArray{

        val jsObj = JSONObject(json.substring(json.indexOf("{"),
            json.lastIndexOf("}") + 1))
        val jsArray : JSONArray  = jsObj.getJSONArray("monday")

        return jsArray
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setLightStatusBar()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayView: RecyclerView = findViewById(R.id.lessons_of_day)
        dayView.layoutManager = LinearLayoutManager(this)
        dayView.adapter = LessonAdapter(createDay(parseJsonToJSONArray(getStringFromJsonFile())))
    }
}


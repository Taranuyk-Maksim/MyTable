package com.pupsik.mytable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    var array : Array<String> = arrayOf("10","fsjdafjsdfsd","130", "vfjsdfjsdlk", "fdsfsd")


    fun getStringFromJsonFile() : String{

        var str : String
        try{
            val a : InputStream = resources.openRawResource(R.raw.day)
            val size = a.available();
            val buffer = ByteArray(size)
            a.read(buffer)
            a.close()
            str = String(buffer, Charsets.UTF_8)

        }catch (ex : IOException ){
            ex.printStackTrace()
            return "IOException"
        }
        return str
    }

    fun createLess(array : Array<String>) : ArrayList<Lesson>{

        val list = ArrayList<Lesson>()

        list.add(Lesson(array[0],
            array[1],
            array[2],
            array[3],
            array[4]))
        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayView: RecyclerView = findViewById(R.id.lessons_of_day)
        dayView.layoutManager = LinearLayoutManager(this)
        dayView.adapter = LessonAdapter(createLess(array))

//        var tx : TextView = findViewById(R.id.tv)
//        tx.setText(getStringFromJsonFile())

    }
}


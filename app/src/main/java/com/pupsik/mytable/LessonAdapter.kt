package com.pupsik.mytable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(private val lesson: ArrayList<Lesson>) : RecyclerView.Adapter<LessonAdapter.LessonHolder>() {
    
    override fun getItemCount() = lesson.size
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lesson_card,parent,false)
        return LessonHolder(itemView)
    }

    override fun onBindViewHolder(holder: LessonAdapter.LessonHolder, position: Int) {
        holder.time?.text = lesson[position].time
        holder.lesson?.text = lesson[position].lessonsName
        holder.auditory?.text = lesson[position].auditory
        holder.type?.text = lesson[position].type
        holder.profrssor?.text = lesson[position].professors
    }

    class LessonHolder(view: View) : RecyclerView.ViewHolder(view) {
        var time : TextView? =null
        var lesson : TextView? =null
        var auditory : TextView? =null
        var type : TextView? =null
        var profrssor : TextView? =null

        init {
            time = itemView.findViewById(R.id.time)
            lesson = itemView.findViewById(R.id.lessons_name)
            auditory = itemView.findViewById(R.id.auditory)
            type = itemView.findViewById(R.id.type)
            profrssor = itemView.findViewById(R.id.professor)
        }
    }

}
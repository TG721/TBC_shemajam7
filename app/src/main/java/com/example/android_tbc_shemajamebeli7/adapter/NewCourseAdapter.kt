package com.example.android_tbc_shemajamebeli7.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_tbc_shemajamebeli7.R
import com.example.android_tbc_shemajamebeli7.data.model.NewCourse
import com.example.android_tbc_shemajamebeli7.databinding.NewCourcesItemBinding

class NewCourseAdapter(private var Courses: List<NewCourse>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class CourseViewHolder(private val NewCourse: NewCourcesItemBinding): RecyclerView.ViewHolder(NewCourse.root){
        @SuppressLint("SetTextI18n")
        fun bind(course: NewCourse){
            NewCourse.apply {
                title.text = course.title
                if(course.icon_type=="settings") {
                    Glide.with(icon)
                        .load(R.drawable.ic_settings)
                        .into(icon)
                }
                else {
                    Glide.with(icon)
                        .load(R.drawable.ic_card)
                        .into(icon)
                }
                val mainColor = Color.parseColor("#${course.main_color}")
                question.text = course.question
                MainLinearLayout.setBackgroundColor(mainColor)
                time.text = "${(course.duration.toInt()/60)} min"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = NewCourcesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as NewCourseAdapter.CourseViewHolder).bind(Courses[position])
    }

    override fun getItemCount(): Int {
        return Courses.size
    }
}
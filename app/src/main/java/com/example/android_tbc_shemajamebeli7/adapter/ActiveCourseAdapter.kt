package com.example.android_tbc_shemajamebeli7.adapter

import android.app.Application
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_tbc_shemajamebeli7.R
import com.example.android_tbc_shemajamebeli7.data.model.ActiveCourse
import com.example.android_tbc_shemajamebeli7.databinding.ActiveCourcesItemBinding

class ActiveCourseAdapter(private var Courses: List<ActiveCourse>, private val AppContext: Application)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = ActiveCourcesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(view, AppContext)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as CourseViewHolder).bind(Courses[position])
    }

    override fun getItemCount(): Int {
        return Courses.size
    }

    inner class CourseViewHolder(private val ActiveCourse: ActiveCourcesItemBinding, private val AppContext: Application) : RecyclerView.ViewHolder(ActiveCourse.root)
    {
        fun bind(course: ActiveCourse){
            ActiveCourse.apply {
                titleTop.text = AppContext.getString(R.string.booked_for, course.booking_time)
                titleTransparent.text = AppContext.getString(R.string.booked_for, course.booking_time)
                Glide.with(iconInside)
                    .load(course.image)
                    .into(iconInside)
                    val mainColor = Color.parseColor("#${course.main_color}")
                    MainConstraintLayout.setBackgroundColor(mainColor)
                    MainConstraintLayout.background.alpha = (course.background_color_percent.toFloat()/100*255).toInt()
                    icon.setBackgroundColor(mainColor)
                    playButtonOvalInside.setColorFilter(mainColor)
                   playButtonOvalInside.alpha = course.play_button_color_percent.toFloat()/100
                    triangle.setColorFilter(mainColor)
                    indicator.setIndicatorColor(mainColor)
                    indicator.progress = course.progress.toInt()
//                    playButtonOvalOutside.setColorFilter(mainColor)
                    titleTop.setTextColor(mainColor)
                    titleTransparent.setTextColor(mainColor)
                    titleTransparent.alpha = course.play_button_color_percent.toFloat()/100

            }
        }
    }


}

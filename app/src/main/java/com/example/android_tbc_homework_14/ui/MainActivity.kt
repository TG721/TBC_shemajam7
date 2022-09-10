package com.example.android_tbc_homework_14.ui

import android.app.Application
import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_tbc_homework_14.MainViewModel
import com.example.android_tbc_homework_14.adapter.ActiveCourseAdapter
import com.example.android_tbc_homework_14.adapter.NewCourseAdapter
import com.example.android_tbc_homework_14.data.model.NewCourse
import com.example.android_tbc_homework_14.databinding.ActivityMainBinding
import com.example.android_tbc_homework_14.utils.MyResponseState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    @Inject
    lateinit var appContext: Application


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

    }

    private fun setup() {
        viewModel.getInfo()

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.myState.collect{
                    d("testireba", "shevida")
                    when(it){
                        is MyResponseState.Loading -> {
                            d("testireba", "loading")
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is MyResponseState.Error -> {
                            d("testireba", "shecdoma")
                            binding.finalText.text = it.message
                            binding.progressBar.visibility = View.GONE
                        }
                        is MyResponseState.Success -> {
                            d("testireba", "success")
                            binding.progressBar.visibility = View.GONE
                             val activeCourAdapter by lazy { ActiveCourseAdapter(it.items.active_courses, appContext) }
                            val newCourAdapter by lazy { NewCourseAdapter(it.items.new_courses) }
                            binding.bottomRecyler.adapter = activeCourAdapter
                            binding.bottomRecyler.layoutManager = LinearLayoutManager(this@MainActivity)
                            binding.TopRecycler.adapter = newCourAdapter
                            binding.TopRecycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}
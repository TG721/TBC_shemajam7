package com.example.android_tbc_homework_14

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_tbc_homework_14.domain.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {

}
    sealed class MyResponseState<T>{
        data class Success<T>(val items: T) : MyResponseState<T>()
        data class Error<T>(val message: String?) : MyResponseState<T>()
        class Loading<T>: MyResponseState<T>()
        class Empty<T> : MyResponseState<T>()

    }


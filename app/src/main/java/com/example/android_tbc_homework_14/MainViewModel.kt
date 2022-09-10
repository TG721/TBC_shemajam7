package com.example.android_tbc_homework_14

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_tbc_homework_14.data.model.Items
import com.example.android_tbc_homework_14.domain.MyRepository
import com.example.android_tbc_homework_14.utils.MyResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {
    private val _myState =
        MutableStateFlow<MyResponseState<Items>>(MyResponseState.Empty()) //mutable state flow
    val myState: StateFlow<MyResponseState<Items>> = _myState //immutable state flow

    fun getInfo() {
        viewModelScope.launch {
            _myState.emit(MyResponseState.Loading())
            var data = repository.doNetworkCall()
            data.collect{
                _myState.value = it
            }
        }

    }
}



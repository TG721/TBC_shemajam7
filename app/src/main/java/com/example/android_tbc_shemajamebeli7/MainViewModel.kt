package com.example.android_tbc_shemajamebeli7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_tbc_shemajamebeli7.data.model.Items
import com.example.android_tbc_shemajamebeli7.domain.MyRepository
import com.example.android_tbc_shemajamebeli7.utils.MyResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {
    private val _myState =
        MutableStateFlow<MyResponseState<Items>>(MyResponseState.Empty()) //mutable state flow
    val myState: StateFlow<MyResponseState<Items>> = _myState //immutable state flow

    fun getInfo() {
        viewModelScope.launch {
            _myState.emit(MyResponseState.Loading())
            val data = repository.doNetworkCall()
            data.collect{
                _myState.value = it
            }
        }

    }
}



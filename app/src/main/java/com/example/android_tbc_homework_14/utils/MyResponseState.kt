package com.example.android_tbc_homework_14.utils

sealed class MyResponseState<T>{
    data class Success<T>(val items: T) : MyResponseState<T>()
    data class Error<T>(val message: String?) : MyResponseState<T>()
    class Loading<T>: MyResponseState<T>()
    class Empty<T> : MyResponseState<T>()

}
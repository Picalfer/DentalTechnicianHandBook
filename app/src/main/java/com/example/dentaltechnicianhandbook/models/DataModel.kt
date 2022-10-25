package com.example.dentaltechnicianhandbook.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val kind: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val steps: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}
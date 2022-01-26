package com.example.dentaltechnicianhandbook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val kind: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
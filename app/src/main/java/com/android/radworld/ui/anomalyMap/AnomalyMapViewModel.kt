package com.android.radworld.ui.anomalyMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnomalyMapViewModel: ViewModel() {

    private val _mutableLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> = _mutableLiveData

    fun someFun() {

    }

}
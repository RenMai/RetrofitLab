package com.example.w1_d4_retrofitlab

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository : WikiRepository = WikiRepository()
    private val query = MutableLiveData<String>()

    val hitCount: LiveData<String> = query.switchMap {
        liveData(Dispatchers.IO) { emit(repository.hitCountCheck(it)) }
    }

    fun queryName(name: String) {
        query.value = name
    }
}
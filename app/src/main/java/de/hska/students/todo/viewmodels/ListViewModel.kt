package de.hska.students.todo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    fun setTitle(name: String) {
        _name.value = name
    }

    override fun onCleared() {
        Log.d("MainViewModel", ">>> onCleared")
        super.onCleared()
    }
}
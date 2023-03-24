package com.example.hilt.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.api.ApiService
import com.example.hilt.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService): ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    var users= _users

    fun fetchUsers(){
        viewModelScope.launch {
            try {
                val response = apiService.getUsers()
                users.postValue(response.body()!!)
            }catch (e:Exception){
                //Handle error
            }
        }
    }
}
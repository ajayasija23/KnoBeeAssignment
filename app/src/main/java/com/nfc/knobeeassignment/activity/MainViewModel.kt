package com.nfc.knobeeassignment.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nfc.knobeeassignment.model.PostResponse
import com.nfc.knobeeassignment.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    val postData:LiveData<PostResponse>
    val errorData:LiveData<String>

    init {
        postData=repository.postData
        errorData=repository.errorData
    }

    fun fetchPosts(){
        viewModelScope.launch {
            repository.loadPosts()
        }
    }

}
package com.nfc.knobeeassignment.network

import androidx.lifecycle.MutableLiveData
import com.nfc.knobeeassignment.model.PostResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService) {
    val postData=MutableLiveData<PostResponse>()
    val errorData=MutableLiveData<String>()

    /**
     * load posts from network
     */
    suspend fun loadPosts(){
        apiService.getPosts().onSuccess {
            postData.postValue(data!!)
        }.onError {
            errorData.postValue(this.response.body()?.message.toString())
        }.onException {
            errorData.postValue(exception.message)
        }
    }
}
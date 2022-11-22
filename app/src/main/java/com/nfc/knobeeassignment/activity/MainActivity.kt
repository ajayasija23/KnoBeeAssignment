package com.nfc.knobeeassignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.nfc.knobeeassignment.R
import com.nfc.knobeeassignment.adapter.PostsAdapter
import com.nfc.knobeeassignment.databinding.ActivityMainBinding
import com.nfc.knobeeassignment.util.log
import com.nfc.knobeeassignment.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindObservers()
        viewModel.fetchPosts()
    }

    private fun bindObservers() {
        viewModel.postData.observe(this){
            val filteredList=it.data?.Gallery?.filter { it.isNotEmpty() }?: emptyList()
            binding.rvPosts.adapter=PostsAdapter(this,filteredList)
           // binding.rvPosts.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        }
        viewModel.errorData.observe(this){
            it.toast(this)
        }
    }
}
package com.fathan.appbanksampahapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathan.appbanksampahapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: ListBankSampahAdapter

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ListBankSampahAdapter()

        mainViewModel = ViewModelProvider(this, MainViewModelFactory()).get(
            MainViewModel::class.java
        )
        binding.rvBankSampah.setHasFixedSize(true)
        binding.rvBankSampah.layoutManager = LinearLayoutManager(this)
        binding.rvBankSampah.adapter = adapter
        mainViewModel.getBankSampah()
        mainViewModel.listBankSampah.observe(this,{
            if (it != null){
                adapter.setList(it)
                Log.d(TAG, "onCreate: ${it.get(1)}")
            }
        })
    }

    companion object{
        const val TAG = "MainActivity"
    }
}
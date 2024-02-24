package com.example.dodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodo.databinding.ActivityMainBinding
import com.example.dodo.models.SelectionDataSource
import com.example.dodo.adapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val selection = SelectionDataSource.sections
    private val adapter = SelectionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
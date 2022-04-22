package com.example.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.databinding.ActivityMainBinding
import com.example.dictionary.ui.adapter.MainPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
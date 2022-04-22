package com.example.dictionary.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentMainBinding
import com.example.dictionary.ui.adapter.MainPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewBinding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val pagerAdapter = MainPagerAdapter(parentFragmentManager,lifecycle)

        viewBinding.pager.adapter = pagerAdapter

        TabLayoutMediator(viewBinding.tabLayout, viewBinding.pager) { tab, position ->
            when(position){
                0-> tab.text = "All words"
                1-> tab.text = "My words"
            }
        }.attach()


    }

}
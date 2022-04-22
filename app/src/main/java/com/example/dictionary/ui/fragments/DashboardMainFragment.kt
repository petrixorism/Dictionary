package com.example.dictionary.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentDashboardMainBinding

class DashboardMainFragment :Fragment(R.layout.fragment_dashboard_main){

    private val binding by viewBinding(FragmentDashboardMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}
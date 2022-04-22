package com.example.dictionary.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentDashboardBinding
import com.example.dictionary.ui.adapter.CursorDashboardAdapter
import com.example.dictionary.ui.viewmodel.DashboardViewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()
    private val adapter = CursorDashboardAdapter()
    private val viewBinding by viewBinding(FragmentDashboardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewBinding.list.adapter = adapter
        viewBinding.searchView.setOnQueryTextListener(listener)
        viewModel.loadWords()


        viewModel.cursorWordsLiveData.observe(viewLifecycleOwner) {
            adapter.submitCursor(it)
        }

        adapter.setItemClick { data->
            Toast.makeText(requireContext(), data.synonym, Toast.LENGTH_LONG).show()
        }

    }

    private val listener = object: SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(p0: String?): Boolean {
            viewModel.search(p0.toString())
            return true
        }

        override fun onQueryTextChange(p0: String?): Boolean {
            return false
        }

    }

}
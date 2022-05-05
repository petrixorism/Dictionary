package com.example.dictionary.ui.fragments

import android.os.Bundle
import android.text.BoringLayout.make
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionary.R
import com.example.dictionary.data.room.WordEntity
import com.example.dictionary.databinding.BottomsheetdialogInsertWordBinding
import com.example.dictionary.databinding.FragmentDashboardBinding
import com.example.dictionary.ui.adapter.CursorDashboardAdapter
import com.example.dictionary.ui.viewmodel.DashboardViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModels()
    private val adapter = CursorDashboardAdapter()
    private val viewBinding by viewBinding(FragmentDashboardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewBinding.list.adapter = adapter
        viewBinding.searchView.setOnQueryTextListener(listener)
        viewModel.loadWords()
        viewModel.failLiveData.observe(viewLifecycleOwner, failObserver)
        viewModel.insertWordLiveData.observe(viewLifecycleOwner, insertObserver)

        viewBinding.addWordBtn.setOnClickListener {
            showBottomSheet()
        }

        viewModel.cursorWordsLiveData.observe(viewLifecycleOwner) {
            adapter.submitCursor(it)
        }

        adapter.setItemClick { data ->
            Toast.makeText(requireContext(), data.synonym, Toast.LENGTH_LONG).show()
        }

    }

    private val listener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
            viewModel.search(p0.toString())
            return true
        }

        override fun onQueryTextChange(p0: String?): Boolean {
            return false
        }
    }

    private val insertObserver = Observer<Unit> {
        Toast.makeText(requireContext(), "Word has been added", Toast.LENGTH_SHORT).show()
        viewModel.loadWords()
    }

    private val failObserver = Observer<String> {

        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private fun showBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        val view = BottomsheetdialogInsertWordBinding.inflate(layoutInflater)

        dialog.setCancelable(true)
        dialog.setContentView(view.root)
        dialog.show()
        view.submitBtn.setOnClickListener {
            viewModel.insertWord(
                wordEntity = WordEntity(
                    0,
                    view.wordEt.text.toString(),
                    view.definitionEt.text.toString(),
                    view.exampleEt.text.toString(),
                    view.synonymEt.text.toString(),
                    view.antonymEt.text.toString(),
                    0,
                )
            )
        }
    }

}
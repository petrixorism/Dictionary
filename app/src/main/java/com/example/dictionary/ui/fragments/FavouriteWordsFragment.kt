package com.example.dictionary.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentFavouriteWordsBinding

class FavouriteWordsFragment:Fragment(R.layout.fragment_favourite_words) {

    private val binding by viewBinding(FragmentFavouriteWordsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}
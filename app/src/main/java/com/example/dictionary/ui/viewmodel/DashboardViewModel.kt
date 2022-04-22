package com.example.dictionary.ui.viewmodel

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.data.repository.WordsRepository
import com.example.dictionary.data.room.WordEntity

class DashboardViewModel : ViewModel() {

    private val repository = WordsRepository()

    val cursorWordsLiveData: MutableLiveData<Cursor> = MutableLiveData()
    val wordLiveData: LiveData<List<WordEntity>> = repository.getAllWords()

    fun loadWords() {
        cursorWordsLiveData.value = repository.getWordsCursor()
    }

    fun search(query: String) {
        if (query.trim().isNotEmpty())
            cursorWordsLiveData.value = repository.getCursorBySearch("%$query%")
    }

}
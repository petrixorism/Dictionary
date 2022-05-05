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
    val insertWordLiveData = MutableLiveData<Unit>()
    val failLiveData = MutableLiveData<String>()


    fun insertWord(wordEntity: WordEntity) {
        if (wordEntity.word.isEmpty()) {
            failLiveData.postValue("Enter word")
        } else if (wordEntity.definition.isEmpty()) {
            failLiveData.postValue("Enter definition")
        } else {
            repository.insertWord(wordEntity)
            insertWordLiveData.postValue(Unit)
        }

    }

    fun loadWords() {
        cursorWordsLiveData.value = repository.getWordsCursor()
    }

    fun search(query: String) {
        if (query.trim().isNotEmpty())
            cursorWordsLiveData.value = repository.getCursorBySearch("%$query%")
    }

}
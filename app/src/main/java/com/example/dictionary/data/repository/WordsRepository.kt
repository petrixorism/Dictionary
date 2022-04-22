package com.example.dictionary.data.repository

import android.database.Cursor
import androidx.lifecycle.LiveData
import com.example.dictionary.data.room.DictionaryDatabase
import com.example.dictionary.data.room.WordEntity

class WordsRepository {

    private val wordDao = DictionaryDatabase.getInstance().getWordDao()

    fun getAllWords(): LiveData<List<WordEntity>> = wordDao.getAllWords()

    fun getWordsCursor(): Cursor = wordDao.getAllWordsCursor()

    fun getCursorBySearch(query: String): Cursor = wordDao.getWordCursorByQuery(query)

    fun updateWord(wordEntity: WordEntity) = wordDao.updateWord(wordEntity)


}
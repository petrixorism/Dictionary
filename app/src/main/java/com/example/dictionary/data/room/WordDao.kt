package com.example.dictionary.data.room

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: WordEntity)

    @Delete
    fun deleteWord(word: WordEntity)

    @Query("SELECT * FROM words")
    fun getAllWords(): LiveData<List<WordEntity>>


    @Query("SELECT * FROM words")
    fun getAllWordsCursor(): Cursor

    @Query("SELECT * FROM words WHERE en_word LIKE :query")
    fun getWordCursorByQuery(query: String): Cursor


}
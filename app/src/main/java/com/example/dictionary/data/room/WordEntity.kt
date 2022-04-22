package com.example.dictionary.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "en_word")
    val word: String,

    @ColumnInfo(name = "en_definition")
    val definition: String,

    @ColumnInfo(name = "example")
    val example: String,

    @ColumnInfo(name = "synonyms")
    val synonym: String,

    @ColumnInfo(name = "antonyms")
    val antonym: String,

    @ColumnInfo(name = "repeat_counst", defaultValue = "0")
    val repeatCounts: Int
)
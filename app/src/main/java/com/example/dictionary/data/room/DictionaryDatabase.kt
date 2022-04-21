package com.example.dictionary.data.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [WordEntity::class],
    version = 1
)

abstract class DictionaryDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {
        private var instance: DictionaryDatabase? = null

        fun init(application: Application) {
            instance = Room.databaseBuilder(application.applicationContext, DictionaryDatabase::class.java, "dictionary.db")
                .createFromAsset("eng_dictionary.db")
                .allowMainThreadQueries()
                .build()
        }

        fun getInstance() = instance!!

    }

}
package com.example.dictionary.app

import android.app.Application
import com.example.dictionary.data.room.DictionaryDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DictionaryDatabase.init(this)
    }


}
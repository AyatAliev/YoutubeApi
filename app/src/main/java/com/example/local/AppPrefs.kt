package com.example.local

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefsModule = module {
    single { AppPrefs(androidContext()) }
}

class AppPrefs(context: Context) {



}
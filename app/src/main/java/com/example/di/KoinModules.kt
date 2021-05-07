package com.example.di

import com.example.core.network.networkModule
import com.example.local.prefsModule
import com.example.remote.remoteDataSourceModule

val koinModules = listOf(
    networkModule,
    remoteDataSourceModule,
    repoModules,
    viewModules,
    prefsModule
)
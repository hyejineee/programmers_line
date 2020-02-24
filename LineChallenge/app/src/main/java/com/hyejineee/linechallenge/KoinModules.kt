package com.hyejineee.linechallenge

import androidx.room.Room
import com.hyejineee.linechallenge.datasources.MemoDataSource
import com.hyejineee.linechallenge.datasources.MemoLocalDataSource
import com.hyejineee.linechallenge.room.MemoAppDatabase
import com.hyejineee.linechallenge.viewmodels.MemoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.inMemoryDatabaseBuilder(
            androidApplication(),
            MemoAppDatabase::class.java
        ).build()
    }
}

val dataSourceModule = module {
    single<MemoDataSource> {
        MemoLocalDataSource(get())
    }
}

val memoViewModelModule = module {
    single {
        MemoViewModel(get())
    }
}

val koinModules = listOf(
    dbModule,
    dataSourceModule,
    memoViewModelModule
)

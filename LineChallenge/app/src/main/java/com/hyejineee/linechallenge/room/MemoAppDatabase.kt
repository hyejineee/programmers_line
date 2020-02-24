package com.hyejineee.linechallenge.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hyejineee.linechallenge.model.ImagePath
import com.hyejineee.linechallenge.model.Memo

@Database(entities = arrayOf(Memo::class, ImagePath::class), version = 1)
abstract class MemoAppDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDAO

    abstract fun imageDao(): ImageDAO
}

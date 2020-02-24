package com.hyejineee.linechallenge.room

import androidx.room.*
import com.hyejineee.linechallenge.model.Memo
import com.hyejineee.linechallenge.model.MemoWithImages
import io.reactivex.Observable

@Dao
interface MemoDAO {

    @Transaction
    @Query("SELECT * FROM memo")
    fun findAllWithImages(): Observable<List<MemoWithImages>>

    @Transaction
    @Query("SELECT * FROM memo WHERE id = :id")
    fun findByIdWithImages(id: Long): Observable<MemoWithImages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo): Long

    @Update
    fun update(memo: Memo)

    @Query("DELETE FROM memo WHERE id = :id")
    fun delete(id: Long)
}

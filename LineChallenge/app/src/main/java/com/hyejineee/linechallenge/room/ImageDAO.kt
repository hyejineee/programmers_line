package com.hyejineee.linechallenge.room

import androidx.room.*
import com.hyejineee.linechallenge.model.ImagePath
import io.reactivex.Observable

@Dao
interface ImageDAO {

    @Query("SELECT * FROM imagepath WHERE memoId = :memoId")
    fun findAllByMemoId(memoId: Long): Observable<List<ImagePath>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(path: ImagePath)

    @Delete
    fun delete(imagePath: ImagePath)

    @Query("DELETE FROM imagepath WHERE memoId = :memoId")
    fun deleteByMemoId(memoId: Long)
}

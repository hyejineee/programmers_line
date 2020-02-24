package com.hyejineee.linechallenge.datasources

import com.hyejineee.linechallenge.model.ImagePath
import com.hyejineee.linechallenge.model.Memo
import com.hyejineee.linechallenge.model.MemoWithImages
import io.reactivex.Completable
import io.reactivex.Observable

interface MemoDataSource {

    fun findAllWithImages(): Observable<List<MemoWithImages>>

    fun findByIdWithImages(id: Long): Observable<MemoWithImages>

    fun save(memo: Memo, images: List<String>): Completable

    fun update(memo: Memo, images: List<String>): Completable

    fun delete(id: Long): Completable

    fun deleteImage(vararg images: ImagePath): Completable
}

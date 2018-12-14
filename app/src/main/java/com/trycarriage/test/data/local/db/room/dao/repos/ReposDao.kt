package com.trycarriage.test.data.local.db.room.dao.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * @name Test
 * Copyrights (c) 12/14/18 Created By Ahmad Najar
 **/
@Dao
interface ReposDao {

    @Insert(onConflict = REPLACE)
    fun insertRepo(repo: Repo): Completable

    @Insert(onConflict = REPLACE)
    fun patchRepos(repo: List<Repo>)

    @Query("select * from repos")
    fun getAllRepos(): Observable<List<Repo>>

    @Query("select * from repos where id=:repoId")
    fun getRepoById(repoId: Int): Repo
}
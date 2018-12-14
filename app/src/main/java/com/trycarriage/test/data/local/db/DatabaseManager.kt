package com.trycarriage.test.data.local.db

import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface DatabaseManager {
    fun getRepos(): Observable<List<Repo>>
    fun insertRepo(repo: Repo): Completable
    fun patchRepos(repo: List<Repo>)
    fun getRepoById(id: Int): Repo
}
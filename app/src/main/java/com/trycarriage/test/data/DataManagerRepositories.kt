package com.trycarriage.test.data

import com.trycarriage.test.data.local.db.DatabaseManager
import com.trycarriage.test.data.remote.api.ApiManager
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class DataManagerRepositories(private val apiManager: ApiManager, private val databaseManager: DatabaseManager) :
    DataManager {
    override fun deleteAll() = databaseManager.deleteAll()

    override fun getRepos(): Observable<List<Repo>> = databaseManager.getRepos()

    override fun insertRepo(repo: Repo): Completable = databaseManager.insertRepo(repo)

    override fun patchRepos(repo: List<Repo>) = databaseManager.patchRepos(repo)

    override fun getRepoById(id: Int): Repo = databaseManager.getRepoById(id)

    override fun getRepos(requestUserRepos: RequestUserRepos): Observable<List<Repo>> =
        Observable.mergeArrayDelayError(getRepos(), apiManager.getRepos(requestUserRepos)
            .doOnNext {
                deleteAll()
                patchRepos(it)
            })

}
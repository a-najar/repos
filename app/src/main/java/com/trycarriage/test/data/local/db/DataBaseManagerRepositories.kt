package com.trycarriage.test.data.local.db

import com.trycarriage.test.data.local.db.room.AppDatabase
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Completable
import io.reactivex.Observable


/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class DataBaseManagerRepositories(private val appDatabase: AppDatabase) : DatabaseManager {

    override fun getRepos(): Observable<List<Repo>> = appDatabase.getReposDao().getAllRepos()

    override fun insertRepo(repo: Repo): Completable = appDatabase.getReposDao().insertRepo(repo)

    override fun patchRepos(repo: List<Repo>) = appDatabase.getReposDao().patchRepos(repo)

    override fun deleteAll() = appDatabase.getReposDao().removeAll()

    override fun getRepoById(id: Int): Repo = appDatabase.getReposDao().getRepoById(id)
}
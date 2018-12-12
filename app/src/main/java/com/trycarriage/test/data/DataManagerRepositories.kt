package com.trycarriage.test.data

import com.trycarriage.test.data.local.db.DatabaseManager
import com.trycarriage.test.data.remote.api.ApiManager
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Single

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class DataManagerRepositories(private val apiManager: ApiManager, private val databaseManager: DatabaseManager) :
    DataManager {

    override fun getRepos(requestUserRepos: RequestUserRepos): Single<ArrayList<Repo>> {
        return apiManager.getRepos(requestUserRepos)
    }


}
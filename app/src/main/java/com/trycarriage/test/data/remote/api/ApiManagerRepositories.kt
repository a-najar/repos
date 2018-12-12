package com.trycarriage.test.data.remote.api

import com.google.gson.reflect.TypeToken
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Single

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class ApiManagerRepositories : ApiManager {

    override fun getRepos(requestUserRepos: RequestUserRepos): Single<ArrayList<Repo>> {
        return Rx2AndroidNetworking.get(ApiEndPoints.USER_REPOS)
            .addPathParameter(requestUserRepos)
            .build()
            .getParseSingle(object : TypeToken<ArrayList<Repo>>() {})
    }
}
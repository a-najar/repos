package com.trycarriage.test.data.remote.api

import com.google.gson.reflect.TypeToken
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Observable

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class ApiManagerRepositories : ApiManager {


    // here you can get the user repos by account name
    override fun getRepos(requestUserRepos: RequestUserRepos): Observable<List<Repo>> =
        Rx2AndroidNetworking.get(ApiEndPoints.USER_REPOS)
            .addPathParameter(requestUserRepos)
            .build()
            .getParseObservable(object : TypeToken<List<Repo>>() {})
}
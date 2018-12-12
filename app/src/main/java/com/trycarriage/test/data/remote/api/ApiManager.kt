package com.trycarriage.test.data.remote.api

import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import io.reactivex.Single

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface ApiManager {

    fun getRepos(requestUserRepos: RequestUserRepos): Single<ArrayList<Repo>>
}
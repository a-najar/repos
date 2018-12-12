package com.trycarriage.test.ui.activities.users.repos

import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import com.trycarriage.test.ui.base.arch.MvvmNavigator

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface UserReposNavigator : MvvmNavigator {
    fun showRepos(it: ArrayList<Repo>?)
}
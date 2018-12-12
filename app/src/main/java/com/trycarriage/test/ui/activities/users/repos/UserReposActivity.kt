package com.trycarriage.test.ui.activities.users.repos

import android.os.Bundle
import com.trycarriage.test.R
import com.trycarriage.test.application.helpers.ktx.showLongToast
import com.trycarriage.test.application.helpers.ui.LayoutRes
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import com.trycarriage.test.ui.base.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

@LayoutRes(R.layout.activity_user_repos)
class UserReposActivity : BaseActivity(), UserReposNavigator {


    private val viewModel: UserReposViewModel<UserReposNavigator> by viewModel()


    override fun bindViews(savedInstanceState: Bundle?) {
        viewModel.attachNavigator(this)
        viewModel.getRepos()
    }


    override fun showRepos(it: ArrayList<Repo>?) {
        showLongToast(it.toString())
    }


}

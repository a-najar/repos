package com.trycarriage.test.ui.activities.users.repos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import com.trycarriage.test.R
import com.trycarriage.test.application.helpers.ktx.*
import com.trycarriage.test.application.helpers.ui.LayoutRes
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import com.trycarriage.test.ui.activities.users.repos.items.ItemRepo
import com.trycarriage.test.ui.base.ui.BaseActivity
import kotlinx.android.synthetic.main.content_user_repos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@LayoutRes(R.layout.activity_user_repos)
class UserReposActivity : BaseActivity(), UserReposNavigator, OnClickListener<IItem<*, *>>,
    SwipeRefreshLayout.OnRefreshListener {


    private val viewModel: UserReposViewModel<UserReposNavigator> by viewModel()
    private var fastItemAdapter: FastItemAdapter<IItem<*, *>> = FastItemAdapter()

    override fun bindViews(savedInstanceState: Bundle?) {
        title = UserReposViewModel.ACCOUNT_NAME
        // init view model and get data
        initViewModel()
        // init list
        initList()
    }

    private fun initList() {
        swipe.init(this)
        listRepos.apply {
            adapter = fastItemAdapter.withOnClickListener(this@UserReposActivity)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initViewModel() {
        viewModel.attachNavigator(this)
        viewModel.getRepos()
    }

    override fun showLoading() {
        super.showLoading()
        swipe.refresh()
    }

    override fun showNoInternetConnection() {
        super.showNoInternetConnection()
        swipe.cancelRefresh()
        fastItemAdapter.clear()
        textPlaceHolder.visible()
    }

    override fun showRepos(it: ArrayList<Repo>?) {
        swipe.cancelRefresh()
        textPlaceHolder.gone()
        it?.let { it.map { repo -> fastItemAdapter.add(ItemRepo().withRepo(repo)) } }
    }

    override fun onRefresh() {
        fastItemAdapter.clear()
        viewModel.getRepos()
    }

    override fun onClick(v: View?, adapter: IAdapter<IItem<*, *>>, item: IItem<*, *>, position: Int): Boolean {
        when (item) {
            is ItemRepo -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.repo.svnUrl)))
            }
        }

        return true
    }

}

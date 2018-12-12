package com.trycarriage.test.ui.activities.users.repos

import com.trycarriage.test.application.helpers.rx.SchedulerProvider
import com.trycarriage.test.data.DataManager
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.ui.base.arch.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class UserReposViewModel<N : UserReposNavigator>(
    dataManager: DataManager, compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BaseViewModel<N>(dataManager, compositeDisposable, schedulerProvider) {


    companion object {
        const val ACCOUNT_NAME = "mralexgray"
    }

    fun getRepos() {
        if (!getNavigator().isConnected()) {
            getNavigator().showNoInternetConnection()
            return
        }
        getNavigator().showLoading()
        compositeDisposable.add(
            dataManager.getRepos(RequestUserRepos(ACCOUNT_NAME))
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ getNavigator().showRepos(it) }, this::handleError)
        )
    }

}
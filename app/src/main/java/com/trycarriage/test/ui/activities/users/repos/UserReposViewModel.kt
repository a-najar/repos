package com.trycarriage.test.ui.activities.users.repos

import com.trycarriage.test.application.helpers.rx.SchedulerProvider
import com.trycarriage.test.data.DataManager
import com.trycarriage.test.data.remote.api.models.users.repos.req.RequestUserRepos
import com.trycarriage.test.ui.base.arch.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class UserReposViewModel<N : UserReposNavigator>(
    dataManager: DataManager, compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BaseViewModel<N>(dataManager, compositeDisposable, schedulerProvider) {


    fun getRepos() {
        compositeDisposable.add(
            dataManager.getRepos(RequestUserRepos("mralexgray"))
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ getNavigator().showRepos(it) }, Timber::d)
        )
    }

}
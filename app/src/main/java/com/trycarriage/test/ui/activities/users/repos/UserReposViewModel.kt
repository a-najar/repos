package com.trycarriage.test.ui.activities.users.repos

import com.trycarriage.test.application.helpers.rx.SchedulerProvider
import com.trycarriage.test.data.DataManager
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


    fun getRepos() {

    }

}
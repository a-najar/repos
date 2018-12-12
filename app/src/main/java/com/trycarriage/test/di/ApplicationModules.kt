package com.trycarriage.test.di

import com.trycarriage.test.application.helpers.rx.AppSchedulerProvider
import com.trycarriage.test.application.helpers.rx.SchedulerProvider
import com.trycarriage.test.data.DataManager
import com.trycarriage.test.data.DataManagerRepositories
import com.trycarriage.test.data.local.db.DataBaseManagerRepositories
import com.trycarriage.test.data.local.db.DatabaseManager
import com.trycarriage.test.data.remote.api.ApiManager
import com.trycarriage.test.data.remote.api.ApiManagerRepositories
import com.trycarriage.test.ui.activities.users.repos.UserReposNavigator
import com.trycarriage.test.ui.activities.users.repos.UserReposViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
object ApplicationModules {
    val modules = listOf(
        module {
            single<DatabaseManager> { DataBaseManagerRepositories(get()) }
            single<ApiManager> { ApiManagerRepositories() }
            single<DataManager> { DataManagerRepositories(get(), get()) }

            single { CompositeDisposable() }
            single<SchedulerProvider> { AppSchedulerProvider() }

        },
        module {
            viewModel { UserReposViewModel<UserReposNavigator>(get(), get(), get()) }
        }

    )
}
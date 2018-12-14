package com.trycarriage.test.ui.base.arch

import androidx.lifecycle.ViewModel
import com.trycarriage.test.application.helpers.rx.SchedulerProvider
import com.trycarriage.test.data.DataManager
import io.reactivex.disposables.CompositeDisposable

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
open class BaseViewModel<N : MvvmNavigator>(
    val dataManager: DataManager,
    val compositeDisposable: CompositeDisposable,
    val schedulerProvider: SchedulerProvider
) : ViewModel(), MvvmModel<N> {

    lateinit var mvvmNavigator: N

    override fun isNavigatorAttached(): Boolean {
        return checkNavigator()
    }

    override fun checkNavigator(): Boolean {
        if (mvvmNavigator != null) {
            return true
        }
        throw MvvmNavigatorException()

    }


    override fun attachNavigator(navigator: N) {
        mvvmNavigator = navigator
    }

    override fun getNavigator(): N {
        return mvvmNavigator
    }

    override fun handleError(error: Throwable) {
        error.message?.let { getNavigator().showMessage(it) }

    }

    class MvvmNavigatorException : KotlinNullPointerException("Please add the mvvm navigator to your view model")
}
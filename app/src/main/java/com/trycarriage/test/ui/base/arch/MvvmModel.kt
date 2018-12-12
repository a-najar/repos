package com.trycarriage.test.ui.base.arch

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface MvvmModel<N : MvvmNavigator> {
    fun attachNavigator(navigator: N)
    fun checkNavigator(): Boolean
    fun isNavigatorAttached(): Boolean
    fun getNavigator(): N
    fun handleError(error: Throwable)
}
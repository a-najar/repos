package com.trycarriage.test.ui.base.arch

import androidx.annotation.StringRes

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface MvvmNavigator {
    fun showLoading()
    fun showError(@StringRes message: String)
    fun showError(@StringRes message: Int)
    fun showMessage(@StringRes message: String)
    fun showMessage(@StringRes message: Int)

    fun isConnected(): Boolean
}
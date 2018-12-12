package com.trycarriage.test.ui.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trycarriage.test.application.helpers.ktx.getLayoutRes
import com.trycarriage.test.application.helpers.network.isNetworkConnected
import com.trycarriage.test.ui.dialogs.connectivity.ConnectivityDialog
import com.trycarriage.test.ui.base.arch.MvvmNavigator
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
open class BaseActivity : AppCompatActivity(), MvvmNavigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content view for of the layout by call it from the annotation
        setContentView(getLayoutRes().layout)
        // init toolbar
        initToolBar()
        // bind views
        bindViews(savedInstanceState)
    }

    private fun initToolBar() {
        toolbar?.let { toolbar ->
            setSupportActionBar(toolbar)
            // add the back stack if exist
            supportActionBar?.let { it.setDisplayHomeAsUpEnabled(getLayoutRes().withBack) }
        }
    }

    open fun bindViews(savedInstanceState: Bundle?) {

    }


    override fun showLoading() {

    }

    override fun showError(message: String) {
    }

    override fun showError(message: Int) {
        showError(getString(message))
    }

    override fun showMessage(message: String) {

    }

    override fun showMessage(message: Int) {
        showMessage(getString(message))
    }

    override fun isConnected(): Boolean {
        return isNetworkConnected()
    }

    override fun showNoInternetConnection() {
        ConnectivityDialog.newInstance().show(supportFragmentManager, ConnectivityDialog.TAG)
    }

}
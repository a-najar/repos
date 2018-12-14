package com.trycarriage.test.ui.dialogs.connectivity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import com.trycarriage.test.R
import com.trycarriage.test.application.helpers.ui.LayoutRes
import com.trycarriage.test.ui.base.ui.BaseDialog
import kotlinx.android.synthetic.main.dialog_connectivity.*

/**
 * @name Test
 * Copyrights (c) 12/13/18 Created By Ahmad Najar
 **/

@LayoutRes(R.layout.dialog_connectivity)
class ConnectivityDialog : BaseDialog() {


    companion object {
        var TAG = ConnectivityDialog::class.java.simpleName
        fun newInstance() = ConnectivityDialog()
    }


    override fun bindViews(savedInstanceState: Bundle?) {
        super.bindViews(savedInstanceState)
        actionOne.setOnClickListener { startActivity(Intent(Settings.ACTION_WIFI_SETTINGS)) }
    }


}
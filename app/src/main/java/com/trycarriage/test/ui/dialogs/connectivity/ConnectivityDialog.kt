package com.trycarriage.test.ui.dialogs.connectivity

import android.os.Bundle
import com.trycarriage.test.R
import com.trycarriage.test.application.helpers.ui.LayoutRes
import com.trycarriage.test.ui.base.ui.BaseDialog

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

    }


}
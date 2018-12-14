package com.trycarriage.test.ui.base.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.trycarriage.test.application.helpers.ktx.getLayoutRes
import com.trycarriage.test.ui.base.arch.MvvmNavigator

/**
 * @name Test
 * Copyrights (c) 12/13/18 Created By Ahmad Najar
 **/
open class BaseDialog : DialogFragment(), MvvmNavigator {


    private lateinit var baseActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity
    }


    var isDialogAddedToScreen = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(getLayoutRes().layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(savedInstanceState)
        isDialogAddedToScreen = true
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val root = ConstraintLayout(activity)
        root.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        dialog.window?.let {
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(true)
        return dialog
    }

    open fun bindViews(savedInstanceState: Bundle?) {

    }

    override fun show(fragmentManager: FragmentManager, tag: String?) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    override fun onDestroy() {
        super.onDestroy()
        isDialogAddedToScreen = false
    }


    override fun showLoading() {
        baseActivity.showLoading()
    }

    override fun showError(message: String) {
        baseActivity.showError(message)
    }

    override fun showError(message: Int) {
        baseActivity.showError(message)
    }

    override fun showMessage(message: String) {
        baseActivity.showMessage(message)
    }

    override fun showMessage(message: Int) {
        baseActivity.showMessage(message)
    }

    override fun isConnected(): Boolean {
        return baseActivity.isConnected()
    }

    override fun showNoInternetConnection() {

    }

}
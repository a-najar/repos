package com.trycarriage.test.application.helpers.logger

import android.util.Log
import timber.log.Timber

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        // log into any crash sdk like firebase and others
    }
}
package com.trycarriage.test.application.helpers.network

import android.content.Context
import android.net.ConnectivityManager


/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/

fun Context.isNetworkConnected(): Boolean =
    (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null

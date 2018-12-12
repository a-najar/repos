package com.trycarriage.test.application.helpers.ktx

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
fun Context.showLongToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Context.showShortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.showLongToast(@StringRes message: Int) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun Context.showShortToast(@StringRes message: Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

package com.trycarriage.test.application.helpers.ktx

import android.view.View

/**
 * @name Test
 * Copyrights (c) 12/13/18 Created By Ahmad Najar
 **/
fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}
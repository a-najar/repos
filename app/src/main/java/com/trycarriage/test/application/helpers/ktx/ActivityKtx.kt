package com.trycarriage.test.application.helpers.ktx

import android.app.Activity
import com.trycarriage.test.application.helpers.ui.LayoutRes

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
fun Activity.getLayoutRes(): LayoutRes {
    val annotation = this::class.java.annotations.find { it is LayoutRes } as? LayoutRes
    if (annotation != null) {
        return annotation
    } else {
        throw KotlinNullPointerException("Please add the LayoutRes annotation at the top of the class")
    }
}
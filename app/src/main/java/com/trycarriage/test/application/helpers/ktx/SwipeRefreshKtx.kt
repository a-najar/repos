package com.trycarriage.test.application.helpers.ktx

import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.trycarriage.test.R

/**
 * @name Test
 * Copyrights (c) 12/13/18 Created By Ahmad Najar
 **/


fun SwipeRefreshLayout.init(onRefreshListener: SwipeRefreshLayout.OnRefreshListener) {
    setColorSchemeColors(ContextCompat.getColor(context, R.color.colorAccent))
    setOnRefreshListener(onRefreshListener)
}

fun SwipeRefreshLayout.refresh() {
    isRefreshing = true
}

fun SwipeRefreshLayout.cancelRefresh() {
    isRefreshing = false
}
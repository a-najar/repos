package com.trycarriage.test.data.remote.api

import com.trycarriage.test.BuildConfig

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
object ApiEndPoints {
    const val SERVER_URL = BuildConfig.SERVER_URL

    const val USER_REPOS = "${SERVER_URL}users/{userName}/repos"

}
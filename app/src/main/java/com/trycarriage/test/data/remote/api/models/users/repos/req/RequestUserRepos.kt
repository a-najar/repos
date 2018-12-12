package com.trycarriage.test.data.remote.api.models.users.repos.req

import com.google.gson.annotations.SerializedName

data class RequestUserRepos(
    @SerializedName("userName")
    val userName: String
)
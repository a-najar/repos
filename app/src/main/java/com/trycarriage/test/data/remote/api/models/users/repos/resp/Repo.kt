package com.trycarriage.test.data.remote.api.models.users.repos.resp

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repos", primaryKeys = ["id"])
data class Repo(
    val createdAt: String?,
    @SerializedName("default_branch")
    val defaultBranch: String,
    @SerializedName("description")
    val description: String?,
    val forks: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("svn_url")
    val svnUrl: String,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("watchers")
    val watchers: Int,
    @SerializedName("watchers_count")
    val watchersCount: Int
)
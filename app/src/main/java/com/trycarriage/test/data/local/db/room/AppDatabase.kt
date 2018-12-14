package com.trycarriage.test.data.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trycarriage.test.data.local.db.room.dao.repos.ReposDao
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo

/**
 * @name Test
 * Copyrights (c) 12/14/18 Created By Ahmad Najar
 **/

@Database(entities = [Repo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getReposDao(): ReposDao
}
package com.trycarriage.test

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.trycarriage.test.data.local.db.room.AppDatabase
import com.trycarriage.test.data.local.db.room.dao.repos.ReposDao
import com.trycarriage.test.data.remote.api.models.users.repos.resp.Repo
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * @name Test
 * Copyrights (c) 12/14/18 Created By Ahmad Najar
 **/

@RunWith(AndroidJUnit4::class)
class ReposTest {

    private lateinit var reposDao: ReposDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val appContext = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java).build()
        reposDao = db.getReposDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val repo = Repo(
            "30/10/1991",
            "master",
            "test",
            10,
            10,
            "test/repo",
            1,
            "ahmad",
            "https://google.com",
            "3010/1991",
            22,
            22
        )

        reposDao.insertRepo(repo)

        val retriedRepo = reposDao.getRepoById(1)
        assertEquals(retriedRepo, repo)
        Assert.assertNotNull(retriedRepo)
    }


    @Test
    @Throws(Exception::class)
    fun getRepoAndCheckIfNull() {
        val retriedRepo = reposDao.getRepoById(3)
        Assert.assertNotNull(retriedRepo)
    }

    @Test
    @Throws(Exception::class)
    fun getRepoAndCheckValues() {
        val repo = Repo(
            "30/10/1991",
            "master",
            null,
            10,
            10,
            "test/repo",
            1,
            "ahmad",
            "https://google.com",
            "3010/1991",
            22,
            22
        )

        reposDao.insertRepo(repo)
        val retriedRepo = reposDao.getRepoById(1)
        assertNull("description are not null", retriedRepo.description)
    }


}
package com.trycarriage.test.application

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.trycarriage.test.BuildConfig
import com.trycarriage.test.application.helpers.logger.ReleaseTree
import com.trycarriage.test.di.ApplicationModules.modules
import org.koin.android.ext.android.startKoin
import timber.log.Timber


/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
        // init androidNetworking
        initNetwork()
        // init Logger
        initLogger()
    }

    /**
     * this func will hel to init the logger
     */
    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    /**
     * add the network layer by using afn networking and I am using
     * library called AfnNetworking URL:https://amitshekhar.me/Fast-Android-Networking/
     */
    private fun initNetwork() {
        AndroidNetworking.initialize(this)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging()
        }
    }
}
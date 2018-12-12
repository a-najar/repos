package com.trycarriage.test.ui.activities.users.repos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.trycarriage.test.R

class UserReposActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_repos)
        setSupportActionBar(toolbar)
    }
}

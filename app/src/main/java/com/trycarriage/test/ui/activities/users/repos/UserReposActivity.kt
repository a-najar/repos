package com.trycarriage.test.ui.activities.users.repos

import android.os.Bundle
import com.trycarriage.test.ui.base.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserReposActivity : BaseActivity() {


    private val viewModel: UserReposViewModel<UserReposNavigator> by viewModel()


    override fun bindViews(savedInstanceState: Bundle?) {

    }


}

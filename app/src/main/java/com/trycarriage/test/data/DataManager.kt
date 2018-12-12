package com.trycarriage.test.data

import com.trycarriage.test.data.local.db.DatabaseManager
import com.trycarriage.test.data.remote.api.ApiManager

/**
 * @name Test
 * Copyrights (c) 12/12/18 Created By Ahmad Najar
 **/
interface DataManager : DatabaseManager, ApiManager {
}
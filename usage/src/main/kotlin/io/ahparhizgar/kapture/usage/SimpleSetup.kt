package io.ahparhizgar.kapture.usage

import io.ahparhizgar.kapture.processor.annotation.Kontainer
import io.ahparhizgar.kapture.processor.annotation.Kontains

@Kontainer(fileName = "", keyPrefix = "profile_")
interface SimpleSetupLocalDataSource {
    @Kontains(Key.USER_NAME)
    suspend fun saveUserName(userName: String)

    @Kontains(Key.USER_NAME)
    suspend fun getUserName(): String?

    suspend fun getUserNameOrDefault(): String = getUserName() ?: "default"

    private object Key {
        const val USER_NAME = "user_name"
    }
}

private fun usage() {
    // for android module
    Kontain.provideSimpleSetupLocalDataSource(context).getUserName
    // for jvm modules
    Kontain.provideSimpleSetupLocalDataSource().getUserName
    // for all platforms
    Kontain.provideSimpleSetupLocalDataSource(dataStore).getUserName
    // underlying implementation
    SimpleSetupLocalDataSource_Imp(datastore).getUserName
}

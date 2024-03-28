package io.ahparhizgar.kapture.usage

import io.ahparhizgar.kapture.processor.annotation.Kontainer
import io.ahparhizgar.kapture.processor.annotation.Kontains

@Kontainer(keyPrefix = "profile_")
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

private suspend fun usage() {
    // for android module
    Kontain.provideSimpleSetupLocalDataSource(context = Unit).getUserName()
    // for jvm modules
    Kontain.provideSimpleSetupLocalDataSource().getUserName()
    // for all platforms
    Kontain.provideSimpleSetupLocalDataSource(dataStore = Unit).getUserName()
    // underlying implementation
    SimpleSetupLocalDataSource_Impl(datastore = Unit).getUserName()
}

class SimpleSetupLocalDataSource_Impl(datastore: Any) : SimpleSetupLocalDataSource {
    override suspend fun saveUserName(userName: String) {
        error("generated method")
    }

    override suspend fun getUserName(): String? {
        error("generated method")
    }
}

object Kontain {
    fun provideSimpleSetupLocalDataSource(context: Any): SimpleSetupLocalDataSource {
        error("generated method")
    }

    fun provideSimpleSetupLocalDataSource(dataStore: Unit): SimpleSetupLocalDataSource {
        error("generated method")
    }

    fun provideSimpleSetupLocalDataSource(): SimpleSetupLocalDataSource {
        error("generated method")
    }
}

package io.ahparhizgar.kapture.usage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.ahparhizgar.kapture.processor.annotation.KontainEncoder
import io.ahparhizgar.kapture.processor.annotation.Kontainer
import io.ahparhizgar.kapture.processor.annotation.KontainerConstructor
import io.ahparhizgar.kapture.processor.annotation.Kontains
import kotlinx.coroutines.flow.first
import javax.annotation.processing.Generated

@Kontainer(keyPrefix = "profile_")
interface CustomMapperLocalDataSource {
    @Kontains(Key.PROFILE)
    suspend fun saveProfile(profile: Profile)

    @Kontains(Key.PROFILE)
    suspend fun getProfile(): Profile?

    suspend fun updateUserName(userName: String)

    suspend fun customImplementedGetter(): Profile?

    private object Key {
        const val PROFILE = "profile"
    }
}

data class Profile(val userName: String)

@KontainerConstructor
abstract class CustomMapperLocalDataSourceMapper(
    private val dataStore: DataStore<Preferences>,
    @KontainEncoder val encoder: JsonEncoder,
) : CustomMapperLocalDataSource {
    override suspend fun customImplementedGetter(): Profile? {
        return dataStore.data.first()[stringPreferencesKey("my_key")]
            ?.let { encoder.decode(it) }
    }

    override suspend fun updateUserName(userName: String) {
        dataStore.edit {
            // do the mapping
        }
    }
}

private suspend fun usage() {
    // for android module
    Kontain2.provideCustomMapperLocalDataSource(context = Unit).getProfile()
    // for jvm modules
    Kontain2.provideCustomMapperLocalDataSource().getProfile()
    // for all platforms
    Kontain2.provideCustomMapperLocalDataSource(dataStore = Unit).getProfile()
    // underlying implementation
    CustomMapperLocalDataSource_Impl(dataStore = Unit, encoder = JsonEncoder()).getProfile()
}

@Generated
class CustomMapperLocalDataSource_Impl(
    dataStore: Any,
    encoder: JsonEncoder
) : CustomMapperLocalDataSourceMapper(
    dataStore as DataStore<Preferences>, encoder
) {
    override suspend fun saveProfile(profile: Profile) {
        error("generated method")
    }

    override suspend fun getProfile(): Profile? {
        error("generated method")
    }

    override suspend fun updateUserName(userName: String) {
        error("generated method")
    }

    override suspend fun customImplementedGetter(): Profile? {
        error("generated method")
    }
}

@Generated
private object Kontain2 {
    fun provideCustomMapperLocalDataSource(context: Any): CustomMapperLocalDataSource {
        error("generated method")
    }

    fun provideCustomMapperLocalDataSource(dataStore: Unit): CustomMapperLocalDataSource {
        error("generated method")
    }

    fun provideCustomMapperLocalDataSource(): CustomMapperLocalDataSource {
        error("generated method")
    }
}

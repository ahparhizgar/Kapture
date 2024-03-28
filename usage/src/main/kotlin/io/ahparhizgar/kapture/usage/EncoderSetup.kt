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

@Kontainer(keyPrefix = "profile_")
interface CustomMapperLocalDataSource {
    @Kontains(Key.PROFILE)
    suspend fun saveProfile(profile: Profile)

    @Kontains(Key.PROFILE)
    suspend fun getProfile(): Profile?

    @Kontains(Key.PROFILE)
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
        return dataStore.data.first().get(stringPreferencesKey("my_key"))
            ?.let { encoder.decode(it) }
    }

    override suspend fun updateUserName(userName: String) {
        dataStore.edit {
            // do the mapping
        }
    }
}

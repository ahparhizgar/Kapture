package io.ahparhizgar.kapture.usage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.ahparhizgar.kapture.processor.annotation.DaggerKontainer
import io.ahparhizgar.kapture.processor.annotation.KontainEncoder
import io.ahparhizgar.kapture.processor.annotation.Kontainer
import io.ahparhizgar.kapture.processor.annotation.KontainerConstructor
import io.ahparhizgar.kapture.processor.annotation.KontainerProvided
import io.ahparhizgar.kapture.processor.annotation.Kontains
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@Kontainer(keyPrefix = "profile_")
@DaggerKontainer
interface DaggerLocalDataSource {
    @Kontains(Key.PROFILE)
    suspend fun saveProfile(profile: Profile)

    @Kontains(Key.PROFILE)
    suspend fun getProfile(): Profile?

    suspend fun updateUserName(userName: String)

    private object Key {
        const val PROFILE = "profile"
    }
}


// Optional custom implementations
@KontainerConstructor
abstract class DaggerLocalDataSourceMapper(
    @KontainerProvided(fileName = "dagger_ds")
    private val dataStore: DataStore<Preferences>
) : DaggerLocalDataSource {
    override suspend fun updateUserName(userName: String) {
        dataStore.edit {
            // do the mapping
        }
    }
}

package io.ahparhizgar.kapture.processor.annotation

annotation class Kontainer(val keyPrefix: String = "")
annotation class KontainerConstructor
annotation class KontainEncoder

annotation class DaggerKontainer
annotation class KontainerProvided(val fileName: String)
annotation class Kontains(val key: String)

const val DEFAULT_FILE_NAME = "data_store_kontainer"

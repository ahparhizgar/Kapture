package io.ahparhizgar.kapture.processor

interface KontainEncoder {
    fun <T> encode(o: T) : String
    fun <T> decode(encoded: String): T
}

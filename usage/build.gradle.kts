plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(":processor"))
    ksp(project(":processor"))
    implementation("androidx.datastore:datastore-preferences-core:1.0.0")
}

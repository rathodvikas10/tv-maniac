plugins {
    id("tvmaniac.kmm.library")
    alias(libs.plugins.serialization)
}

kotlin {
    android()
    ios()

    sourceSets {
        sourceSets["commonMain"].dependencies {
            api(projects.core.database)
            api(projects.core.networkutil)

            implementation(libs.ktor.serialization)
        }

    }
}

android {
    namespace = "com.thomaskioko.tvmaniac.tmdb.api"
}
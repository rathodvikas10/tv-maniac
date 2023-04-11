plugins {
    id("tvmaniac.kmm.data")
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
}

kotlin {
    android()
    ios()

    sourceSets {

        sourceSets["androidMain"].dependencies {
            implementation(libs.ktor.okhttp)
        }

        sourceSets["commonMain"].dependencies {
            implementation(project(":shared:data:tmdb:api"))
            implementation(project(":shared:data:shows:api"))
            implementation(libs.kermit)
            implementation(libs.kotlinInject.runtime)
            implementation(libs.ktor.core)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.sqldelight.extensions)
            implementation(libs.sqldelight.extensions)
        }

        sourceSets["commonTest"].dependencies {
            implementation(libs.ktor.serialization)
        }

        sourceSets["iosMain"].dependencies {
            implementation(libs.ktor.darwin)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.negotiation)
        }
    }
}

android {
    namespace = "com.thomaskioko.tvmaniac.tmdb.implementation"
}

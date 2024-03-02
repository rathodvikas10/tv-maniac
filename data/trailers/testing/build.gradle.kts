plugins { id("plugin.tvmaniac.multiplatform") }

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        api(projects.data.trailers.api)
        implementation(projects.database)

        implementation(libs.coroutines.core)
      }
    }
  }
}

plugins { id("plugin.tvmaniac.multiplatform") }

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        implementation(projects.core.base)
        implementation(projects.data.featuredshows.api)
        implementation(projects.data.trendingshows.api)
        implementation(projects.data.upcomingshows.api)
        implementation(projects.data.search.api)

        api(libs.decompose.decompose)
        api(libs.essenty.lifecycle)
        api(libs.kotlinx.collections)

        implementation(libs.coroutines.core)
        implementation(libs.kotlinInject.runtime)
      }
    }

    commonTest {
      dependencies {
        implementation(projects.data.search.testing)

        implementation(libs.bundles.unittest)
      }
    }
  }
}

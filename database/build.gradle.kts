plugins {
  alias(libs.plugins.tvmaniac.kotlin.android)
  alias(libs.plugins.tvmaniac.multiplatform)
  alias(libs.plugins.sqldelight)
  alias(libs.plugins.ksp)
}

kotlin {
  sourceSets {
    androidMain { dependencies { implementation(libs.sqldelight.driver.android) } }

    commonMain {
      dependencies {
        implementation(projects.core.base)
        implementation(libs.sqldelight.primitive.adapters)
        implementation(libs.kotlinInject.runtime)
        implementation(libs.kotlinx.datetime)
      }
    }

    androidUnitTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.sqldelight.driver.jvm)
      }
    }

    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation(libs.kotest.assertions)
      }
    }

    iosMain {
      dependencies {
        implementation(libs.sqldelight.driver.native)

        // See https://github.com/cashapp/sqldelight/issues/4357
        implementation(libs.stately.common)
        implementation(libs.stately.isolate)
        implementation(libs.stately.iso.collections)
      }
    }

    jvmTest { dependencies { implementation(libs.sqldelight.driver.jvm) } }
  }
}

dependencies {
  add("kspAndroid", libs.kotlinInject.compiler)
  add("kspIosX64", libs.kotlinInject.compiler)
  add("kspIosArm64", libs.kotlinInject.compiler)
}

android { namespace = "com.thomaskioko.tvmaniac.db" }

sqldelight {
  databases { create("TvManiacDatabase") { packageName.set("com.thomaskioko.tvmaniac.core.db") } }
  linkSqlite.set(true)
}

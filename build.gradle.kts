plugins {
    id("java")
    id("idea")
}

repositories {
    mavenCentral()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}

dependencies {
    implementation(files("libs/algs4.jar"))
    implementation("org.jetbrains:annotations:24.1.0")
}
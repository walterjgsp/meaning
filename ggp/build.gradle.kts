import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "io.wcode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // Clikt
    implementation("com.github.ajalt:clikt:2.3.0")

    // Gson
    implementation("com.google.code.gson:gson:2.8.6")

    // Kafka
    implementation ("org.apache.kafka:kafka-clients:2.4.0")

    // Testing dependencies
    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        testLogging {
            showStandardStreams = true
            events = setOf(PASSED, FAILED, SKIPPED)
        }
        useJUnitPlatform()
    }
}
package org.jetbrains.compose.reload.utils

import org.gradle.util.GradleVersion
import org.jetbrains.compose.reload.core.testFixtures.TestEnvironment
import org.jetbrains.kotlin.tooling.core.KotlinToolingVersion
import org.junit.jupiter.api.extension.ExtensionContext

enum class TestedGradleVersion(val version: GradleVersion) {
    G_8_7(GradleVersion.version("8.7")),
    G_8_11(GradleVersion.version("8.11.1"));

    override fun toString(): String {
        return version.version
    }
}

enum class TestedKotlinVersion(val version: KotlinToolingVersion) {
    KT_2_1_FIREWORK(
        KotlinToolingVersion(TestEnvironment.fireworkVersion ?: error("Missing 'firework.version'"))
    ),
    ;

    override fun toString(): String {
        return version.toString()
    }
}

enum class TestedComposeVersion(val version: String) {
    C_1_7(KotlinToolingVersion("1.7.1").toString()), ;

    override fun toString(): String {
        return version
    }
}

enum class TestedAndroidVersion(val version: String) {
    AGP_8_5("8.5.2"),
    AGP_8_7("8.7.1");

    override fun toString(): String {
        return version
    }
}

var ExtensionContext.kotlinVersion: TestedKotlinVersion? by extensionContextProperty()
var ExtensionContext.gradleVersion: TestedGradleVersion? by extensionContextProperty()
var ExtensionContext.composeVersion: TestedComposeVersion? by extensionContextProperty()
var ExtensionContext.androidVersion: TestedAndroidVersion? by extensionContextProperty()
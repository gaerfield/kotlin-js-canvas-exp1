plugins {
    kotlin("multiplatform") version "1.3.72"
}

repositories {
    jcenter()
    mavenCentral()
}

kotlin {
    js { browser() }
//
//    sourceSets {
//        val commonMain by getting
//        val jsMain by getting
//
//        commonMain.dependencies {
//            implementation(kotlin("stdlib-common"))
//            implementation("org.jetbrains.kotlinx:kotlinx-html-common:0.6.12")
//        }
//        jsMain.dependencies {
//            implementation(kotlin("stdlib-js"))
//            implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.12")
//        }
//    }
}

val commonMain = kotlin.sourceSets["commonMain"]
val jsMain = kotlin.sourceSets["jsMain"]

commonMain.dependencies {
    implementation(kotlin("stdlib-common"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-common:0.7.1")
}

jsMain.dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1")
}

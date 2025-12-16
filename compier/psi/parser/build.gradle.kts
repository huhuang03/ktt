plugins {
    kotlin("jvm")
}

group = "com.th.ktt"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ant.importBuild("buildLexer.xml")
ant.properties["builddir"] = layout.buildDirectory.get().asFile.absolutePath

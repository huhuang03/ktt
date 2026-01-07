plugins {
    kotlin("jvm")
}

group = "com.th.ktt"
version = "0.0.1-SNAPSHOT"

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

configurations {
    create("jflex")
}

dependencies {
    add("jflex", "de.jflex:jflex:1.9.1")
}

ant.importBuild("buildLexer.xml")
tasks.withType<AntTarget>().configureEach {
    doFirst {
        ant.properties["flex.classpath"] =
            configurations["jflex"].asPath
    }
}
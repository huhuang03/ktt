plugins {
    kotlin("jvm")
}

group = "com.th.ktt"
version = "0.0.1"

val jflexPath: Configuration by configurations.creating

dependencies {
    testImplementation(kotlin("test"))
    jflexPath("de.jflex:jflex:1.9.1")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ant.importBuild("buildLexer.xml")
ant.properties["builddir"] = layout.buildDirectory.get().asFile.absolutePath

// why not config as top??
tasks.findByName("lexer")!!.apply {
    doFirst {
        ant.properties["flex.classpath"] = jflexPath.asPath
    }
}

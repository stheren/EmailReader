import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
    application
    id("org.openjfx.javafxplugin")
}

val javalinVersion: String by project
val slf4jVersion: String by project
val jacksonVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("net.pwall.json:json-kotlin-schema:0.31")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
}

javafx {
    modules("javafx.controls", "javafx.fxml", "javafx.web")
}

application {
    mainClassName = "com.stheren.email_reader.graphical.Window"
}

tasks.getByName<ShadowJar>("shadowJar") {
    archiveClassifier.set("fat")
    archiveVersion.set(project.version.toString())
    archiveBaseName.set(project.name)
}
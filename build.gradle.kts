import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow")
    application
    id("org.openjfx.javafxplugin")
}

val jacksonVersion: String by project
val schemaVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("net.pwall.json:json-kotlin-schema:$schemaVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("junit:junit:4.13.1")

    testImplementation(kotlin("test"))
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

tasks.test {
    useJUnitPlatform()
}
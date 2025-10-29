plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:4.13.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.json:json:20240303")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("ch.qos.logback:logback-classic:1.5.9")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-log4j12:1.7.36")
    implementation("net.minidev:json-smart:2.6.0")
    implementation("org.openjfx:javafx-controls:22")
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    implementation("org.openjfx:javafx-fxml:23")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml")
    version = "22"
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "org.example.APP"
}
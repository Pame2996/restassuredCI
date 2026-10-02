plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.rest-assured:rest-assured:6.0.1")
    implementation("org.json:json:20260814")
    implementation("io.rest-assured:json-schema-validator:6.0.1")
    implementation("io.cucumber:cucumber-java:7.34.8")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.34.8")
}

tasks.test {
    useJUnitPlatform()
}



tasks.register<JavaExec>("cucumber") {
    dependsOn(tasks.assemble, tasks.testClasses)

    mainClass.set("io.cucumber.core.cli.Main")

    classpath = sourceSets.test.get().runtimeClasspath

    args = listOf(
        "--plugin", "pretty",
        "--plugin", "html:build/reports/cucumber-report.html",
        "--plugin", "json:build/reports/cucumber-report.json",
        "--glue", "steps",
        "src/test/resources",
        "--tags", project.findProperty("suite")?.toString() ?: "@SmokeTest"
    )
}
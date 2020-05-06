plugins {
    kotlin("jvm")
}

dependencies {
    val gdxVersion: String by project
    val ktxVersion: String by project
    val junitVersion: String by project

    implementation(kotlin("stdlib"))

    implementation("com.badlogicgames.gdx:gdx:$gdxVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_6
    targetCompatibility = JavaVersion.VERSION_1_6
}
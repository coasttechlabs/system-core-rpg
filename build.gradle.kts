plugins {
	kotlin("jvm") version "2.2.21"
}

group = "com.rpg"
version = project.property("version") as String

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${project.property("coroutines.version")}")
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain((project.property("java.version") as String).toInt())
}
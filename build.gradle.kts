plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.commons.logging.commons.logging)
    implementation(libs.commons.net.commons.net)
    implementation(libs.javax.xml.bind.jaxb.api)
    implementation(libs.net.java.jna)
    testImplementation(libs.junit)
}

group = "com.ceridwen.util"
version = "1.8.2"
description = "com.ceridwen.util:ceridwen-util"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/OpenXingZhi/ceridwen-util")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

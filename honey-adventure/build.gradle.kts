plugins {
    `honey-java`
    `honey-unit-test`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    api(project(":honey-common"))
    api(libs.bundles.adventure)
}

honeyPublish {
    artifactId = "honey-adventure"
}
plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    compileOnly(project(":honey-adventure"))
    compileOnly(libs.bundles.adventure)
}

honeyPublish {
    artifactId = "honey-configs-adventure-common"
}
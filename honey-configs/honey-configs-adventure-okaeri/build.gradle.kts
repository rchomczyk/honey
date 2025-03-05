plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    compileOnly(project(":honey-common"))
    compileOnly(libs.bundles.adventure)
    api(project(":honey-configs:honey-configs-adventure-common"))
    api(libs.bundles.okaeri.configs)
}

honeyPublish {
    artifactId = "honey-configs-adventure-okaeri"
}
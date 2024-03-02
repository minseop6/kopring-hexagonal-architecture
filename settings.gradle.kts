plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "kopring-hexagonal-architecture"

include("domain")
include("application")
include("adapter")

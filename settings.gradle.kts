pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")


        ///// DO NOT SUBMIT
        mavenLocal {
            content {
                includeGroupByRegex("com\\.varabyte\\.kobweb.*")
            }
        }
//        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}

rootProject.name = "appxyz"

include(":site")

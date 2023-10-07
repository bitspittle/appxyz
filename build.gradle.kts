subprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        ///// DO NOT SUBMIT
        mavenLocal {
            content {
                includeGroupByRegex("com\\.varabyte\\.kobweb.*")
            }
        }
//        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}

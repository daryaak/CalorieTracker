plugins{
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.plcoding.tracker_domain"
}

dependencies{
    implementation(project(Modules.core))
    implementation(Coroutines.coroutines)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

}
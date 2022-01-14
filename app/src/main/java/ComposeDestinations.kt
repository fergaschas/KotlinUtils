/* via maven central*/
/**
Author : Rafael Costa
Github : @raamcosta
 */

@Destination
@Composable
fun ProfileScreen() { /*...*/
}

@Destination
@Composable
fun ProfileScreen(
    id: Int, // <-- required navigation argument
    groupName: String?, // <-- optional navigation argument
    isOwnUser: Boolean = false // <-- optional navigation argument
) { /*...*/
}

/**
 * DestinationsNavigator is a wrapper interface to NavController that if declared as a parameter,
 * will be provided for free by the library. NavController can also be provided in the exact same
 * way, but it ties your composables to a specific implementation which will make it harder to test
 * and preview.
 */
@Destination
@Composable
fun SomeOtherScreen(
    navigator: DestinationsNavigator
) {
    /*...*/
    navigator.navigate(ProfileScreenDestination(id = 7, groupName = "Kotlin programmers"))
}

/**
 * NavGraphs is a generated file that describes your navigation graphs and their destinations.
 * By default all destinations will belong to "root", but you can use the navGraph argument of the
 * annotation to have certain screens in nested navigation graphs.
 */
DestinationsNavHost(navGraph = NavGraphs.root)

/**
 * groovy - build.gradle(:app)
 */
plugins {
    //...
    id 'com.google.devtools.ksp' version '1.5.31-1.0.0' // Depends on your kotlin version
}
implementation 'io.github.raamcosta.compose-destinations:core:1.1.4-beta'
ksp 'io.github.raamcosta.compose-destinations:ksp:1.1.4-beta'

/**
If you want to use animations between screens and/or bottom sheet screens, replace above core dependency with:
*/
implementation 'io.github.raamcosta.compose-destinations:animations-core:<version>'
/**
this will use Accompanist Navigation-Animation and Accompanist Navigation-Material internally.
Read more about the next steps to configure these features here
 */

/**
 * groovy/kotlin - gradle.build(:app) (same level as plugins and android blocks):
 */
kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
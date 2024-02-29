import com.dutkinght.moviedb.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFirebaseConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds
    override val libraries: Map<String, List<String>>
        get() = libs

    override fun apply(target: Project) {
        super.apply(target)
        with(target) {
            dependencies {
                val bom = libs.findLibrary("firebase-bom").get()
                add("implementation", platform(bom))
            }
        }
    }

    companion object {
        val plugIds = listOf("com.google.devtools.ksp")

        val libs = mapOf(
            "implementation" to listOf(
                "firebase-firestore",
                "firebase-auth",
                "firebase-storage"
            ),
            "ksp" to listOf("hilt.android.compiler")
        )
    }
}

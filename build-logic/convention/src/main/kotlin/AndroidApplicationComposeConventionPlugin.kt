import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.dutkinght.moviedb.configureAndroidCompose
import com.dutkinght.moviedb.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds

    override val libraries: Map<String, List<String>>
        get() = libs

    override fun apply(target: Project) {
        super.apply(target)
        with(target) {
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureAndroidCompose(extension)
            dependencies {
                add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
            }
        }

    }

    companion object {
        private val plugIds = listOf("com.android.application", "com.google.devtools.ksp")

        val libs = mapOf(
            "implementation" to listOf(
                "androidx-compose-constraintlayout",
                "androidx-compose-ui",
                "androidx-compose-ui-graphics",
                "androidx-compose-ui-tool-preview",
                "androidx-compose-ui-tooling",
                "androidx-compose-material3"
            ), "ksp" to listOf("hilt.android.compiler")
        )
    }
}

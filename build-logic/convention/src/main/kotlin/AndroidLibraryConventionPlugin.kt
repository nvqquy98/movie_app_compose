import com.android.build.gradle.LibraryExtension
import com.dutkinght.moviedb.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds

    override fun apply(target: Project) {
        super.apply(target)
        with(target) {
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }
        }
    }

    companion object {
        private val plugIds = listOf("com.android.library", "org.jetbrains.kotlin.android")
    }
}
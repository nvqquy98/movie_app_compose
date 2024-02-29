import com.android.build.gradle.LibraryExtension
import com.dutkinght.moviedb.configureAndroidCompose
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds

    override fun apply(target: Project) {
        super.apply(target)

        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }

    companion object {
        private val plugIds = listOf("com.android.library")
    }
}
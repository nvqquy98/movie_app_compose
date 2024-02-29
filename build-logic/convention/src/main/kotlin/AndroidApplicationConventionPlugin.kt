import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.dutkinght.moviedb.configureKotlinAndroid
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds

    override fun apply(target: Project) {
        super.apply(target)
        with(target) {
            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
            }
        }
    }

    companion object {
        private val plugIds = listOf("com.android.application", "org.jetbrains.kotlin.android")
    }
}
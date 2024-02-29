import androidx.annotation.CallSuper
import com.dutkinght.moviedb.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

open class CommonApplicationConventionPlugin : Plugin<Project> {
    protected open val pluginIds: List<String> = listOf()
    protected open val libraries: Map<String, List<String>> = mapOf()

    @CallSuper
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                for (pluginId in pluginIds) {
                    apply(pluginId)
                }

                dependencies {
                    libraries.forEach { (configName, configs) ->
                        configs.forEach { add(configName, libs.findLibrary(it).get()) }
                    }
                }
            }
        }
    }
}

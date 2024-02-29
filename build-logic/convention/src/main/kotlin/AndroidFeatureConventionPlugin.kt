class AndroidFeatureConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds
    override val libraries: Map<String, List<String>>
        get() = libs

    companion object {
        private val plugIds = listOf("com.android.application", "org.jetbrains.kotlin.android")
        val libs = mapOf("implementation" to listOf("kotlinx.coroutines.android"))
    }
}
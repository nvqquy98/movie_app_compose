class AndroidHiltConventionPlugin : CommonApplicationConventionPlugin() {
    override val pluginIds: List<String>
        get() = plugIds
    override val libraries: Map<String, List<String>>
        get() = libs

    companion object {
        val plugIds = listOf("com.google.devtools.ksp")

        val libs = mapOf(
            "implementation" to listOf("hilt.android", "androidx.hilt.navigation.compose"),
            "ksp" to listOf("hilt.android.compiler")
        )
    }
}

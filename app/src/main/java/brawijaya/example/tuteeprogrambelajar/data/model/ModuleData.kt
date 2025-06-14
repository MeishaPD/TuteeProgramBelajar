package brawijaya.example.tuteeprogrambelajar.data.model

data class ProgrammeData(
    val id: Int,
    val title: String,
    val imageRes: Int,
    val modules: List<ModuleData>
)

data class ModuleData(
    val id: Int,
    val name: String,
    val title: String,
    val description: String,
    val keywords: List<String> = emptyList()
)

data class ModuleInfo(
    val title: String,
    val description: String,
    val keywords: List<String>
)
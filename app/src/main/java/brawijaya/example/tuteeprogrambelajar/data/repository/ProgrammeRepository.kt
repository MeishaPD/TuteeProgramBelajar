package brawijaya.example.tuteeprogrambelajar.data.repository

import brawijaya.example.tuteeprogrambelajar.R
import brawijaya.example.tuteeprogrambelajar.data.model.ModuleData
import brawijaya.example.tuteeprogrambelajar.data.model.ModuleInfo
import brawijaya.example.tuteeprogrambelajar.data.model.ProgrammeData
import brawijaya.example.tuteeprogrambelajar.ui.viewmodel.SearchResult

object ProgrammeRepository {

    val programmeList = listOf(
        ProgrammeData(
            id = 1,
            title = "Pemrograman Web",
            imageRes = R.drawable.bg_card_1,
            modules = generateModules(1, listOf(
                ModuleInfo(
                    "Intro HTML",
                    "HTML atau Hypertext Markup Language adalah sebuah bahasa markup yang digunakan untuk membuat halaman web.",
                    listOf("html", "markup", "web", "tag", "element", "struktur", "dasar")
                ),
                ModuleInfo(
                    "CSS Styling",
                    "Cascading Style Sheets untuk styling dan layout halaman web yang menarik dan responsif.",
                    listOf("css", "styling", "layout", "responsif", "design", "selector", "property")
                ),
                ModuleInfo(
                    "JavaScript Fundamentals",
                    "Bahasa pemrograman untuk membuat interaktivitas pada halaman web dan aplikasi.",
                    listOf("javascript", "js", "programming", "interaktif", "function", "variable", "dom")
                ),
                ModuleInfo(
                    "Responsive Design",
                    "Teknik membuat tampilan web yang optimal di berbagai ukuran layar menggunakan media queries.",
                    listOf("responsive", "mobile", "tablet", "media query", "breakpoint", "flexbox", "grid")
                ),
                ModuleInfo(
                    "Web Deployment",
                    "Cara melakukan deployment website ke hosting atau cloud platform.",
                    listOf("deployment", "hosting", "server", "cloud", "publish", "domain", "ftp")
                )
            ))
        ),
        ProgrammeData(
            id = 2,
            title = "Pemrograman Android",
            imageRes = R.drawable.bg_card_2,
            modules = generateModules(6, listOf(
                ModuleInfo(
                    "Kotlin Basics",
                    "Dasar-dasar bahasa pemrograman Kotlin untuk pengembangan aplikasi Android modern.",
                    listOf("kotlin", "android", "programming", "variable", "function", "class", "syntax")
                ),
                ModuleInfo(
                    "Android UI/UX",
                    "Desain antarmuka pengguna yang intuitif menggunakan Jetpack Compose dan Material Design.",
                    listOf("ui", "ux", "design", "compose", "material", "layout", "widget", "theme")
                ),
                ModuleInfo(
                    "Database Integration",
                    "Integrasi database lokal dan cloud untuk penyimpanan data aplikasi Android.",
                    listOf("database", "sqlite", "room", "cloud", "firebase", "data", "storage")
                ),
                ModuleInfo(
                    "Notification System",
                    "Membuat sistem notifikasi push dan lokal di aplikasi Android.",
                    listOf("notification", "push", "local", "alert", "message", "fcm", "firebase")
                ),
                ModuleInfo(
                    "Publishing to Play Store",
                    "Proses finalisasi, signing APK, dan upload ke Google Play Store.",
                    listOf("playstore", "publish", "apk", "signing", "release", "google", "upload")
                )
            ))
        ),
        ProgrammeData(
            id = 3,
            title = "Data Science",
            imageRes = R.drawable.bg_card_3,
            modules = generateModules(11, listOf(
                ModuleInfo(
                    "Python for Data Science",
                    "Menggunakan Python dan library seperti Pandas, NumPy untuk analisis data.",
                    listOf("python", "pandas", "numpy", "data", "analysis", "library", "dataframe")
                ),
                ModuleInfo(
                    "Machine Learning",
                    "Algoritma machine learning dan implementasinya untuk prediksi dan klasifikasi data.",
                    listOf("ml", "machine learning", "algorithm", "prediction", "classification", "model", "ai")
                ),
                ModuleInfo(
                    "Data Visualization",
                    "Teknik visualisasi data menggunakan matplotlib, seaborn, dan tools lainnya.",
                    listOf("visualization", "chart", "graph", "matplotlib", "seaborn", "plot", "dashboard")
                ),
                ModuleInfo(
                    "Big Data Processing",
                    "Teknik menangani dan analisis data dalam skala besar menggunakan Hadoop dan Spark.",
                    listOf("big data", "hadoop", "spark", "processing", "distributed", "cluster", "etl")
                ),
                ModuleInfo(
                    "Model Deployment",
                    "Menerapkan model machine learning ke dalam aplikasi atau web menggunakan API.",
                    listOf("deployment", "api", "model", "production", "docker", "cloud", "serving")
                )
            ))
        ),
        ProgrammeData(
            id = 4,
            title = "Project Management",
            imageRes = R.drawable.bg_card_4,
            modules = generateModules(16, listOf(
                ModuleInfo(
                    "Agile Methodology",
                    "Metodologi Agile dan Scrum untuk manajemen proyek software yang efektif.",
                    listOf("agile", "scrum", "sprint", "kanban", "methodology", "iterative", "team")
                ),
                ModuleInfo(
                    "Risk Management",
                    "Identifikasi, analisis, dan mitigasi risiko dalam proyek teknologi.",
                    listOf("risk", "management", "mitigation", "analysis", "assessment", "planning", "strategy")
                ),
                ModuleInfo(
                    "Team Leadership",
                    "Keterampilan kepemimpinan dan komunikasi untuk memimpin tim teknologi.",
                    listOf("leadership", "communication", "team", "management", "motivation", "delegation", "skills")
                ),
                ModuleInfo(
                    "Project Planning Tools",
                    "Penggunaan tools seperti Jira, Trello, dan Notion dalam perencanaan proyek.",
                    listOf("jira", "trello", "notion", "tools", "planning", "tracking", "workflow")
                ),
                ModuleInfo(
                    "Stakeholder Management",
                    "Strategi komunikasi dan manajemen ekspektasi stakeholder dalam proyek.",
                    listOf("stakeholder", "communication", "expectation", "management", "client", "requirements", "feedback")
                )
            ))
        ),
        ProgrammeData(
            id = 5,
            title = "Pemrograman Dasar Java",
            imageRes = R.drawable.bg_card_5,
            modules = generateModules(21, listOf(
                ModuleInfo(
                    "Pengenalan Java",
                    "Sejarah, konsep OOP, dan ekosistem Java dalam pengembangan aplikasi.",
                    listOf("java", "oop", "object oriented", "jvm", "history", "ecosystem", "introduction")
                ),
                ModuleInfo(
                    "Dasar Sintaks Java",
                    "Struktur dasar program Java, variabel, tipe data, dan kontrol alur.",
                    listOf("syntax", "variable", "data type", "control flow", "loop", "condition", "basic")
                ),
                ModuleInfo(
                    "Pemrograman Berbasis Objek",
                    "Konsep class, object, inheritance, polymorphism, dan encapsulation di Java.",
                    listOf("class", "object", "inheritance", "polymorphism", "encapsulation", "abstraction", "oop")
                ),
                ModuleInfo(
                    "Java Collections",
                    "Penggunaan ArrayList, HashMap, dan struktur data lain di Java.",
                    listOf("collections", "arraylist", "hashmap", "list", "map", "set", "data structure")
                ),
                ModuleInfo(
                    "File Handling & Database",
                    "Bekerja dengan file dan koneksi database menggunakan JDBC.",
                    listOf("file", "io", "database", "jdbc", "connection", "sql", "data persistence")
                )
            ))
        ),
        ProgrammeData(
            id = 6,
            title = "Quality Assurance",
            imageRes = R.drawable.bg_card_6,
            modules = generateModules(26, listOf(
                ModuleInfo(
                    "Dasar Quality Assurance",
                    "Konsep dasar QA, jenis-jenis pengujian, dan proses QA dalam SDLC.",
                    listOf("qa", "quality assurance", "testing", "sdlc", "process", "methodology", "basics")
                ),
                ModuleInfo(
                    "Manual Testing",
                    "Teknik pengujian aplikasi secara manual, pembuatan test case dan bug report.",
                    listOf("manual testing", "test case", "bug report", "functional testing", "user acceptance", "exploratory")
                ),
                ModuleInfo(
                    "Automation Testing",
                    "Penggunaan tools seperti Selenium, JUnit, dan Appium untuk pengujian otomatis.",
                    listOf("automation", "selenium", "junit", "appium", "automated testing", "framework", "scripts")
                ),
                ModuleInfo(
                    "Performance Testing",
                    "Teknik pengujian performa aplikasi menggunakan JMeter dan tools lainnya.",
                    listOf("performance", "load testing", "jmeter", "stress testing", "benchmarking", "optimization", "metrics")
                ),
                ModuleInfo(
                    "CI/CD & QA Tools Integration",
                    "Integrasi QA dalam pipeline CI/CD menggunakan Jenkins dan GitLab CI.",
                    listOf("ci/cd", "jenkins", "gitlab", "pipeline", "integration", "continuous testing", "devops")
                )
            ))
        ),
        ProgrammeData(
            id = 7,
            title = "Data Mining",
            imageRes = R.drawable.bg_card_7,
            modules = generateModules(31, listOf(
                ModuleInfo(
                    "Introduction to Data Mining",
                    "Definisi data mining, proses KDD, dan aplikasi di berbagai bidang.",
                    listOf("data mining", "kdd", "knowledge discovery", "pattern", "analysis", "introduction", "application")
                ),
                ModuleInfo(
                    "Clustering dan Classification",
                    "Metode clustering (K-Means, Hierarchical) dan classification (Decision Tree, Naive Bayes).",
                    listOf("clustering", "classification", "k-means", "hierarchical", "decision tree", "naive bayes", "algorithm")
                ),
                ModuleInfo(
                    "Association Rule Mining",
                    "Teknik pencarian pola asosiasi dalam dataset menggunakan algoritma Apriori dan FP-Growth.",
                    listOf("association rules", "apriori", "fp-growth", "market basket", "frequent patterns", "mining", "algorithm")
                ),
                ModuleInfo(
                    "Anomaly Detection",
                    "Mendeteksi outlier dan anomali dalam data menggunakan Isolation Forest dan LOF.",
                    listOf("anomaly detection", "outlier", "isolation forest", "lof", "fraud detection", "unusual patterns", "statistics")
                ),
                ModuleInfo(
                    "Text Mining",
                    "Teknik ekstraksi informasi dari data teks menggunakan NLP dan sentiment analysis.",
                    listOf("text mining", "nlp", "sentiment analysis", "information extraction", "text processing", "natural language", "corpus")
                )
            ))
        ),
        ProgrammeData(
            id = 8,
            title = "Pemrograman Swift",
            imageRes = R.drawable.bg_card_8,
            modules = generateModules(36, listOf(
                ModuleInfo(
                    "Swift Basics",
                    "Dasar-dasar sintaks Swift, variabel, tipe data, dan kontrol alur.",
                    listOf("swift", "ios", "syntax", "variable", "data type", "control flow", "basics", "apple")
                ),
                ModuleInfo(
                    "iOS UI Programming",
                    "Pembuatan UI iOS menggunakan SwiftUI dan storyboard.",
                    listOf("ios", "ui", "swiftui", "storyboard", "interface", "design", "view", "controller")
                ),
                ModuleInfo(
                    "Data Persistence di iOS",
                    "Teknik penyimpanan data lokal di iOS menggunakan UserDefaults, CoreData, dan SQLite.",
                    listOf("data persistence", "userdefaults", "coredata", "sqlite", "storage", "local data", "ios")
                ),
                ModuleInfo(
                    "Networking & API",
                    "Teknik melakukan request API dan parsing JSON menggunakan URLSession.",
                    listOf("networking", "api", "json", "urlsession", "http", "rest", "web service", "parsing")
                ),
                ModuleInfo(
                    "App Deployment & TestFlight",
                    "Mempersiapkan aplikasi untuk rilis di App Store dan distribusi via TestFlight.",
                    listOf("deployment", "app store", "testflight", "distribution", "release", "publishing", "ios", "apple")
                )
            ))
        )
    )

    fun getProgrammes(): List<ProgrammeData> = programmeList

    fun searchProgrammes(query: String): List<SearchResult> {
        if (query.isBlank()) {
            return programmeList.map { SearchResult.ProgrammeResult(it) }
        }

        val results = mutableListOf<SearchResult>()
        val searchQuery = query.lowercase().trim()

        programmeList.forEach { programme ->
            val programmeMatches = programme.title.contains(searchQuery, ignoreCase = true)

            val matchingModules = programme.modules.filter { module ->
                module.title.contains(searchQuery, ignoreCase = true) ||
                        module.description.contains(searchQuery, ignoreCase = true) ||
                        module.name.contains(searchQuery, ignoreCase = true) ||
                        module.keywords.any { keyword -> keyword.contains(searchQuery, ignoreCase = true) }
            }

            when {
                // If programme title matches and there are no specific module matches, show the programme
                programmeMatches && matchingModules.isEmpty() -> {
                    results.add(SearchResult.ProgrammeResult(programme))
                }
                // If there are matching modules, show each matching module
                matchingModules.isNotEmpty() -> {
                    matchingModules.forEach { module ->
                        results.add(SearchResult.ModuleResult(programme, module))
                    }
                }
                // If programme title matches and there are module matches, show both
                programmeMatches && matchingModules.isNotEmpty() -> {
                    results.add(SearchResult.ProgrammeResult(programme))
                    matchingModules.forEach { module ->
                        results.add(SearchResult.ModuleResult(programme, module))
                    }
                }
            }
        }

        // Remove duplicates and sort by relevance
        return results.distinctBy { result ->
            when (result) {
                is SearchResult.ProgrammeResult -> "programme_${result.programme.id}"
                is SearchResult.ModuleResult -> "module_${result.programme.id}_${result.module.id}"
            }
        }.sortedWith(compareBy<SearchResult> { result ->
            when (result) {
                is SearchResult.ProgrammeResult -> {
                    // Programme results have higher priority if title matches exactly
                    if (result.programme.title.equals(searchQuery, ignoreCase = true)) 0 else 2
                }
                is SearchResult.ModuleResult -> {
                    // Module results with title match have higher priority than description/keyword matches
                    when {
                        result.module.title.contains(searchQuery, ignoreCase = true) -> 1
                        result.module.keywords.any { it.equals(searchQuery, ignoreCase = true) } -> 3
                        else -> 4
                    }
                }
            }
        })
    }
}

fun generateModules(
    startId: Int,
    moduleInfos: List<ModuleInfo>
): List<ModuleData> {
    return moduleInfos.mapIndexed { index, moduleInfo ->
        ModuleData(
            id = startId + index,
            name = "Modul ${index + 1}",
            title = moduleInfo.title,
            description = moduleInfo.description,
            keywords = moduleInfo.keywords
        )
    }
}
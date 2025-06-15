package brawijaya.example.tuteeprogrambelajar.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import brawijaya.example.tuteeprogrambelajar.data.model.ModuleData
import brawijaya.example.tuteeprogrambelajar.data.model.ProgrammeData
import brawijaya.example.tuteeprogrambelajar.data.repository.ProgrammeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class SearchResult {
    data class ProgrammeResult(val programme: ProgrammeData) : SearchResult()
    data class ModuleResult(val programme: ProgrammeData, val module: ModuleData) : SearchResult()
}

class ProgrammeViewModel : ViewModel() {

    private val _programmeList = mutableStateListOf<ProgrammeData>()
    val programmeList: List<ProgrammeData> get() = _programmeList

    var searchQuery by mutableStateOf("")
        private set

    var searchResults by mutableStateOf<List<SearchResult>>(emptyList())
        private set

    var isSearching by mutableStateOf(false)
        private set

    private var searchJob: Job? = null

    init {
        loadProgrammes()
    }

    private fun loadProgrammes() {
        _programmeList.clear()
        _programmeList.addAll(ProgrammeRepository.getProgrammes())
        performSearch()
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query

        searchJob?.cancel()

        searchJob = viewModelScope.launch {
            isSearching = true
            delay(300)
            performSearch()
            isSearching = false
        }
    }

    private fun performSearch() {
        searchResults = ProgrammeRepository.searchProgrammes(searchQuery)
    }

    fun clearSearch() {
        searchQuery = ""
        performSearch()
    }

    fun getAllProgrammes(): List<SearchResult> {
        return _programmeList.map { SearchResult.ProgrammeResult(it) }
    }

    fun getProgrammeById(id: Int): ProgrammeData? {
        return _programmeList.find { it.id == id }
    }

    fun getModuleById(programmeId: Int, moduleId: Int): ModuleData? {
        return _programmeList
            .find { it.id == programmeId }
            ?.modules
            ?.find { it.id == moduleId }
    }

    fun getAllProgrammeModules(programmeId: Int): List<ModuleData> {
        return _programmeList.find { it.id == programmeId }
            ?.modules ?: emptyList()
    }
}
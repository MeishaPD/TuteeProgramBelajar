package brawijaya.example.tuteeprogrambelajar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import brawijaya.example.tuteeprogrambelajar.ui.screens.programbelajar.ProgramBelajarScreen
import brawijaya.example.tuteeprogrambelajar.ui.screens.ruangbelajar.RuangBelajarScreen

sealed class Screen (val route: String) {
    object ProgramBelajar : Screen("program_belajar")
    object RuangBelajar : Screen("ruang_belajar")
}

@Composable
fun AppNavigation (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ProgramBelajar.route
    ) {
        composable(Screen.ProgramBelajar.route) {
            ProgramBelajarScreen(navController = navController)
        }
        composable(Screen.RuangBelajar.route) {
            RuangBelajarScreen(navController = navController)
        }
    }
}
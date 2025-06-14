package brawijaya.example.tuteeprogrambelajar.ui.screens.programbelajar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.SearchOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import brawijaya.example.tuteeprogrambelajar.ui.components.BottomNavigation
import brawijaya.example.tuteeprogrambelajar.ui.navigation.Screen
import brawijaya.example.tuteeprogrambelajar.ui.screens.programbelajar.components.ModuleSearchCard
import brawijaya.example.tuteeprogrambelajar.ui.screens.programbelajar.components.ProgramBelajarCard
import brawijaya.example.tuteeprogrambelajar.ui.viewmodel.ProgrammeViewModel
import brawijaya.example.tuteeprogrambelajar.ui.viewmodel.SearchResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgramBelajarScreen(
    navController: NavController,
    viewModel: ProgrammeViewModel = viewModel()
) {
    val searchResults by remember { derivedStateOf { viewModel.searchResults } }
    val isSearching by remember { derivedStateOf { viewModel.isSearching } }
    val searchQuery by remember { derivedStateOf { viewModel.searchQuery } }

    Scaffold(
        topBar = {
            Surface(
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                color = Color(0xFF052B4F),
                shadowElevation = 4.dp
            ) {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color.White
                            ),
                            modifier = Modifier.size(35.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ChevronLeft,
                                contentDescription = "Back"
                            )
                        }
                    },
                    title = {
                        Text(
                            text = "Program Belajar",
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 16.dp)
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                currentRoute = Screen.ProgramBelajar.route,
                onNavigate = {}
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp)
                .padding(top = 16.dp)
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Cari Program atau Modul",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFCBD5E1),
                    unfocusedPlaceholderColor = Color(0xFF031A2F),
                    focusedContainerColor = Color(0xFFCBD5E1),
                    focusedPlaceholderColor = Color(0xFF031A2F),
                    unfocusedTextColor = Color(0xFF031A2F),
                    focusedTextColor = Color(0xFF031A2F),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isSearching) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                strokeWidth = 2.dp,
                                color = Color(0xFF031A2F)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }

                        if (searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = { viewModel.clearSearch() }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = "Clear Search",
                                    tint = Color(0xFF031A2F)
                                )
                            }
                        } else {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = "Search",
                                    tint = Color(0xFF031A2F)
                                )
                            }
                        }
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )

            if (searchQuery.isEmpty() && !isSearching) {
                OutlinedButton(
                    onClick = { navController.navigate(Screen.RuangBelajar.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF052B4F)
                    ),
                    border = BorderStroke(1.dp, Color(0xFF052B4F))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Ruang Belajar",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                lineHeight = 24.sp
                            ),
                            modifier = Modifier.weight(1f)
                        )

                        Icon(
                            imageVector = Icons.Rounded.ChevronRight,
                            contentDescription = "Go To Ruang Belajar"
                        )
                    }
                }
            } else {
                Text(
                    text = "Hasil Pencarian",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        lineHeight = 20.sp
                    ),
                    color = Color(0xFFCC9215),
                    modifier = Modifier.padding(bottom = 16.dp).align(Alignment.Start)
                )
            }

            if (searchResults.isEmpty() && searchQuery.isNotEmpty() && !isSearching) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.SearchOff,
                            contentDescription = "No Results",
                            tint = Color.Gray,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Tidak ada program atau modul yang cocok dengan pencarian \"$searchQuery\"",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Coba gunakan kata kunci yang berbeda",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray.copy(alpha = 0.7f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    val programmeResults = searchResults.filterIsInstance<SearchResult.ProgrammeResult>()
                    val moduleResults = searchResults.filterIsInstance<SearchResult.ModuleResult>()

                    items(programmeResults) { result ->
                        ProgramBelajarCard(
                            modifier = Modifier.height(120.dp),
                            imageRes = result.programme.imageRes,
                            title = result.programme.title
                        )
                    }

                    moduleResults.forEach { result ->
                        item(span = { GridItemSpan(2) }) {
                            ModuleSearchCard(
                                programme = result.programme,
                                module = result.module,
                                searchQuery = searchQuery
                            )
                        }
                    }

                    if (searchQuery.isEmpty()) {
                        item(span = { GridItemSpan(2) }) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFF052B4F).copy(alpha = 0.1f)
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Info,
                                        contentDescription = "Info",
                                        tint = Color(0xFF052B4F),
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "Gunakan kotak pencarian untuk menemukan modul spesifik berdasarkan topik atau kata kunci",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color(0xFF052B4F)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
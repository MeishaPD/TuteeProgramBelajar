package brawijaya.example.tuteeprogrambelajar.ui.screens.kelas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Chat
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import brawijaya.example.tuteeprogrambelajar.ui.navigation.Screen
import brawijaya.example.tuteeprogrambelajar.ui.screens.kelas.components.ModuleCard
import brawijaya.example.tuteeprogrambelajar.ui.viewmodel.ProgrammeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KelasScreen(
    navController: NavController,
    viewModel: ProgrammeViewModel = viewModel()
) {

    val modules = viewModel.getAllProgrammeModules(1)
    var expandedModules by remember { mutableStateOf(setOf<Int>()) }

    Scaffold(
        topBar = {
            Surface(
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                color = Color(0xFF052B4F),
                shadowElevation = 4.dp,
                modifier = Modifier.drawBehind {
                    val strokeWidth = 3.dp.toPx()
                    val cornerRadius = 32.dp.toPx()
                    val width = size.width
                    val height = size.height

                    val path = Path().apply {
                        moveTo(0f, height - cornerRadius)

                        quadraticTo(0f, height, cornerRadius, height)

                        lineTo(width - cornerRadius, height)

                        quadraticTo(width, height, width, height - cornerRadius)
                    }

                    drawPath(
                        path = path,
                        color = Color(0xFFFFB61A),
                        style = Stroke(width = strokeWidth)
                    )
                }
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
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Pemrograman Web",
                                color = Color.White
                            )
                            Text(
                                text = "Senin, 09:00 - 11:00",
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    lineHeight = 21.sp
                                )
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .padding(bottom = 16.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 16.dp)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = Color(0xFFFFD376),
                shadowElevation = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Pemrograman web adalah proses pembuatan dan pengembangan situs web atau aplikasi web. Di pembelajaran ini, kita akan belajar menjadi full-stack developer.",
                    modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 18.sp
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF052B4F),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.Chat,
                    contentDescription = "Chat Tutor"
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 100.dp)
            ) {
                items(modules) { module ->
                    ModuleCard(
                        module = module,
                        isExpanded = expandedModules.contains(module.id),
                        onExpandToggle = {
                            expandedModules = if (expandedModules.contains(module.id)) {
                                expandedModules - module.id
                            } else {
                                expandedModules + module.id
                            }
                        },
                        onModuleClick = {
                            navController.navigate(Screen.ModuleDetail.route)
                        }
                    )
                }
            }
        }
    }
}
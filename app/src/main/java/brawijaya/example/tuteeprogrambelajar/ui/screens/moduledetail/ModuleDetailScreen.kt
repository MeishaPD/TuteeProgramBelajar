package brawijaya.example.tuteeprogrambelajar.ui.screens.moduledetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronLeft
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import brawijaya.example.tuteeprogrambelajar.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModuleDetailScreen(
    navController: NavController
) {
    var showChapterDialog by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    data class Chapter(val id: String, val title: String, val scrollPosition: Int)

    val chapters = listOf(
        Chapter("chapter1", "1. Definisi HTML", 0),
        Chapter("chapter2", "2. HTML5", 1200)
    )

    Scaffold(
        contentWindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Top),
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
                            text = "Modul 1: Intro HTML",
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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 24.dp)
                .padding(horizontal = 32.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(7.5.dp),
                color = Color(0xFF052B4F),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 24.dp)
                    .clip(RoundedCornerShape(7.5.dp))
                    .clickable {
                        showChapterDialog = true
                    }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "Select Chapter",
                    tint = Color(0xFFFFB61A),
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Text(
                    text = "1. Definisi HTML",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    ),
                    color = Color(0xFF031A2F),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .testTag("chapter1")
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "\t\t\t\tHTML atau Hypertext Markup Language adalah sebuah bahasa markup yang digunakan untuk membuat sebuah halaman web. Meskipun sering diartikan sebagai bahasa pemrograman dasar yang digunakan untuk membuat sebuah web, HTML pada dasarnya adalah bahasa markup (penanda) berbasis teks atau bisa juga disebut sebagai formatting language (bahasa untuk memformat). HTML menjadi dasar dalam pembuatan website statis.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
                Spacer(Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.html_structure),
                    contentDescription = "HTML Structure",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "\t\t\t\tSintaks kode HTML diatur dan disusun dengan menggunakan tag. Berikut ini contoh kerangka HTML sederhana.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
                Spacer(Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.html_example),
                    contentDescription = "HTML Example",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(32.dp))

                Text(
                    text = "2. HTML5",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    ),
                    color = Color(0xFF031A2F),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .testTag("chapter2")
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "\t\t\t\tHTML5 adalah versi terbaru dari HTML. Versi terakhir HTML sebelum HTML versi 5 adalah HTML 4.01 dan XHTML 1.1. HTML5 menawarkan elemen-elemen baru yang dapat digunakan untuk pengembangan web. Kini, HTML5 telah diperbarui lagi menjadi HTML versi 5.1. HTML5 memiliki keunggulan sebagai berikut:",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
                Text(
                    text =
                        "1. Fitur baru yang didasarkan pada integrasi HTML, CSS, DOM, dan JavaScript.\n" +
                                "2. Mengurangi kebutuhan untuk plugin eksternal (seperti Adobe Flash).\n" +
                                "3. Penanganan kesalahan yang lebih baik.\n" +
                                "4. Lebih banyak markup element yang dapat digunakan untuk menggantikan scripting.\n" +
                                "5. HTML5 dimungkinkan menjadi perangkat mandiri.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "\t\t\t\tSalah satu keunggulan HTML5 adalah merevolusi cara penulisan tag-tag dalam versi HTML sebelumnya menjadi lebih sederhana secara semantik. Selain itu penulisan tag-tag dengan menggunakan pola penulisan HTML4 masih dapat dilakukan dalam HTML.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        lineHeight = 15.sp
                    ),
                    color = Color.Black,
                    textAlign = TextAlign.Justify
                )
                Spacer(Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.html5),
                    contentDescription = "HTML5",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(24.dp))
            }
        }
    }

    if (showChapterDialog) {
        AlertDialog(
            onDismissRequest = { showChapterDialog = false },
            confirmButton = {
                TextButton(
                    onClick = { showChapterDialog = false }
                ) {
                    Text("Close")
                }
            },
            title = {
                Text(
                    text = "Select Chapter",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color(0xFF031A2F)
                )
            },
            text = {
                LazyColumn {
                    items(chapters) { chapter ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clickable {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(chapter.scrollPosition)
                                    }
                                    showChapterDialog = false
                                },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF052B4F)
                            )
                        ) {
                            Text(
                                text = chapter.title,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp
                                ),
                                color = Color.White,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            },
            containerColor = Color.White,
            shape = RoundedCornerShape(16.dp)
        )
    }
}
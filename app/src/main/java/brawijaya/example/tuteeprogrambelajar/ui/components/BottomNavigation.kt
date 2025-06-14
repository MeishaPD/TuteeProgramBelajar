package brawijaya.example.tuteeprogrambelajar.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import brawijaya.example.tuteeprogrambelajar.R

@Composable
fun BottomNavItem(
    icon: ImageVector? = null,
    painterRes: Int? = null,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    filledIcon: ImageVector? = null
) {
    val itemColor = if (isSelected) Color(0xFFFAFAFA) else Color.White
    val displayIcon = if (isSelected && filledIcon != null) filledIcon else icon

    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            icon != null -> {
                Icon(
                    imageVector = displayIcon!!,
                    contentDescription = label,
                    tint = itemColor,
                    modifier = Modifier.size(24.dp)
                )
            }

            painterRes != null -> {
                Icon(
                    painter = painterResource(id = painterRes),
                    contentDescription = label,
                    tint = itemColor,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
                lineHeight = 15.sp
            ),
            color = itemColor
        )
    }
}


@Composable
fun BottomNavigation(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .zIndex(1f)
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
        containerColor = Color(0xFF052B4F),
        contentColor = Color.Black,
        tonalElevation = 0.dp,
        contentPadding = PaddingValues(0.dp)
    ) {
        Surface(
            color = Color(0xFF052B4F),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavItem(
                    icon = Icons.Rounded.Home,
                    filledIcon = Icons.Rounded.Home,
                    label = "Beranda",
                    isSelected = false,
                    onClick = {  }
                )

                BottomNavItem(
                    icon = Icons.AutoMirrored.Rounded.MenuBook,
                    label = "Belajar",
                    isSelected =  false,
                    onClick = {  }
                )
                BottomNavItem(
                    painterRes = R.drawable.icon_caritutor,
                    label = "Cari Tutor",
                    isSelected = false,
                    onClick = {  }
                )
                BottomNavItem(
                    painterRes = R.drawable.icon_daftarkelas,
                    label = "Daftar Kelas",
                    isSelected = false,
                    onClick = {  }
                )
            }
        }
    }
}
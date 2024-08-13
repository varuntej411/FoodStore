package com.food.store.presentation.navigation.bottomnavbar

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.food.store.R
import com.food.store.ui.theme.Pink40
import com.food.store.ui.theme.Purple40
import com.food.store.ui.theme.PurpleGrey40

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(
    navItems: List<BottomNavigationBarItems>,
    selectedItem: Int,
    onClickItem: (Int) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .clip(RoundedCornerShape(20)),
        tonalElevation = 30.dp,
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = {
                    onClickItem.invoke(index)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.cartCount > 0) {
                                Badge(containerColor = Pink40) {
                                    Text(
                                        text = item.cartCount.toString(),
                                        fontSize = 10.sp,
                                        color = Color.White,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontFamily = FontFamily.SansSerif,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            } else if (item.hasBadgeDot) {
                                Badge(containerColor = Pink40)
                            }
                        }
                    ) {
                        Column(
                            modifier = Modifier.padding(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title
                            )
                            Text(
                                text = item.title,
                                fontSize = 10.sp,
                                style = MaterialTheme.typography.labelLarge,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                },
//                colors = NavigationDrawerItemDefaults.colors(
//                    unselectedBadgeColor = Color.White,
//                    unselectedTextColor = Color.Green,
//                    selectedBadgeColor = Color.Black,
//                    selectedTextColor = Color.Red,
//                    unselectedIconColor = Color.DarkGray,
//                    selectedIconColor = Color.Black,
//                    selectedContainerColor = Color.Magenta,
//                    unselectedContainerColor = Color.Blue
//                ),
                colors = NavigationBarItemColors(
                    unselectedIconColor = PurpleGrey40,
                    unselectedTextColor = PurpleGrey40,
                    selectedIconColor = Purple40,
                    selectedTextColor = Purple40,
                    selectedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    disabledIconColor = PurpleGrey40,
                    disabledTextColor = PurpleGrey40
                )
            )
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }
}

data class BottomNavigationBarItems(
    var title: String,
    @DrawableRes var icon: Int,
    var cartCount: Int,
    var hasBadgeDot: Boolean = false
)

var bottomBarItems = listOf(
    BottomNavigationBarItems(
        title = "home",
        icon = R.drawable.unselectedhome,
        cartCount = 0,
        hasBadgeDot = false
    ),
    BottomNavigationBarItems(
        title = "search",
        icon = R.drawable.unselectedsearch,
        cartCount = 0,
        hasBadgeDot = false
    ),
    BottomNavigationBarItems(
        title = "cart",
        icon = R.drawable.unselectedcart,
        cartCount = 1,
        hasBadgeDot = false
    ),
    BottomNavigationBarItems(
        title = "profile",
        icon = R.drawable.profile,
        cartCount = 0,
        hasBadgeDot = true
    )
)

@Preview
@Composable
fun BottomNavBarPreview() {
    BottomNavigationBar(
        navItems = bottomBarItems,
        selectedItem = 0,
        onClickItem = {}
    )
}
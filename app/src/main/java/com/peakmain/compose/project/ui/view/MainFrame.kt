package com.peakmain.compose.project.ui.view

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：
 */
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.peakmain.compose.project.bean.main.NavigationItem
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_999999
import com.peakmain.compose.project.ui.view.main.HomeFragment
import com.peakmain.compose.project.ui.view.main.MineFragment
import com.peakmain.compose.project.ui.view.main.ProjectFragment
import com.peakmain.compose.project.ui.view.main.TypeFragment

@Composable
fun MainFrame() {
    val navigationItems = listOf(
        NavigationItem("首页", Icons.Default.Home),
        NavigationItem("项目", Icons.Default.Article),
        NavigationItem("分类", Icons.Default.Category),
        NavigationItem("我的", Icons.Default.Person)
    )
    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                navigationItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationItem(
                        selected = currentNavigationIndex == index,
                        onClick = { currentNavigationIndex = index },
                        icon = {
                            Icon(imageVector = navigationItem.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = navigationItem.title)
                        },
                        selectedContentColor = Color_149EE7,
                        unselectedContentColor = Color_999999
                    )
                }
            }
        },
    ) {
        when (currentNavigationIndex) {
            0 -> HomeFragment()
            1 -> ProjectFragment()
            2 -> TypeFragment()
            else -> MineFragment()
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}


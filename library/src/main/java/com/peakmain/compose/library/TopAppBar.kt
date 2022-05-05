package com.peakmain.compose.library

import android.graphics.Color.luminance
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * author ：Peakmain
 * createTime：2022/5/4
 * mail:2726449200@qq.com
 * describe：
 */

/**
 * @param title 标题
 * @param modifier Modifier，设置后会和已经设置好Modifier进行合并
 * @param navigationIcon 左边图标
 * @param backgroundColor 背景颜色
 * @param actions 右边图标
 * @param isImmersive 是否是沉浸式
 * @param darkIcons 状态栏的文字图标颜色是黑色还是白色，默认是false（白色）
 * @param content 内容区域
 */
@Composable
fun TopAppBarCenter(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    actions: @Composable RowScope.() -> Unit = {},
    isImmersive: Boolean = false,
    darkIcons: Boolean = false,
    content: @Composable (PaddingValues) -> Unit,
) {
    val topAppBarHeight = 56.dp
    var statusBarHeight = 0
    var statusBarHeightDp = Dp(0f)
    if (isImmersive) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = darkIcons
            )
        }
        with(LocalContext.current) {
            statusBarHeight =
                resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height",
                    "dimen",
                    "android"))
        }
        with(LocalDensity.current) {
            statusBarHeightDp = statusBarHeight.toDp()
        }
    }

    Scaffold(topBar = {
        val constraintSet = ConstraintSet {
            val titleRef = createRefFor("title")
            val navigationIconRef = createRefFor("navigationIcon")
            val actionsRef = createRefFor("actions")
            constrain(titleRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            constrain(navigationIconRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            constrain(actionsRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        }
        ConstraintLayout(constraintSet, modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .height(topAppBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp)
            .then(modifier)) {
            Box(
                Modifier
                    .layoutId("title")
                    .padding(horizontal = 4.dp)
            ) {
                ProvideTextStyle(value = MaterialTheme.typography.h6) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                        content = title
                    )
                }
            }
            if (navigationIcon != null) {
                Box(modifier = Modifier
                    .layoutId("navigationIcon")
                    .padding(start = 4.dp)) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                        content = navigationIcon
                    )
                }
            }
            Row(
                Modifier
                    .layoutId("actions")
                    .padding(end = 4.dp),
                content = actions
            )

        }
    }) {
        content(it)
    }

}

package com.peakmain.compose.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

/**
 * author ：Peakmain
 * createTime：2022/5/4
 * mail:2726449200@qq.com
 * describe：
 */
private val TopAppBarHeight = 56.dp

@Composable
fun TopAppBarCenter(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
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
           constrain(actionsRef){
               top.linkTo(parent.top)
               bottom.linkTo(parent.bottom)
               end.linkTo(parent.end)
           }
       }
       ConstraintLayout(constraintSet,
           modifier = Modifier
               .fillMaxWidth()
               .background(backgroundColor)
               .height(TopAppBarHeight)
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
               Modifier.layoutId("actions").padding(end = 4.dp),
               content = actions
           )

       }
   }) {
        content(it)
   }

}

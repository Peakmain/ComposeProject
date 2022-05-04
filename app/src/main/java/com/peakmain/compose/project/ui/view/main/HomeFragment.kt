package com.peakmain.compose.project.ui.view.main

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：
 */
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.peakmain.compose.library.TopAppBarCenter

@Composable
fun HomeFragment() {
    TopAppBarCenter(title = {
        Text(text = "首页", color = Color.White)
    }) {
        Text(text = "我是首页")
    }
}


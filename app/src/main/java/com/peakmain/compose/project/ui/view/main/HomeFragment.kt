package com.peakmain.compose.project.ui.view.main

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：
 */
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.peakmain.compose.ext.orSize
import com.peakmain.compose.library.TopAppBarCenter
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_2DCDF5
import com.peakmain.compose.project.viewmodel.home.HomeFragmentViewModel
import com.peakmain.compose.ui.GridLayout
import com.peakmain.compose.ui.divier.PkDashDivider
import com.peakmain.compose.ui.divier.PkDivider
import com.peakmain.compose.ui.divier.PkFullDivider
import com.peakmain.compose.ui.flow.PkFlowRow
import com.peakmain.compose.ui.title.PkTitle
import com.peakmain.compose.ui.title.PkTitleType

@Composable
fun HomeFragment(viewModel: HomeFragmentViewModel = viewModel()) {
    TopAppBarCenter (
        title = {
            Text(text = "首页", color = Color.White)
        },
        isImmersive = true,
        modifier = Modifier.background(Brush.linearGradient(listOf(Color_149EE7, Color_2DCDF5)))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomRow("我是垂直实线") {
                //默认垂直实线
                PkDivider()
            }
            //水平实线
            PkFullDivider(modifier = Modifier.padding(top = 10.dp), isHorizontal = true)
            CustomRow("我是垂直虚线") {
                PkDivider(isDash=true)
            }
            //水平虚线
            PkDashDivider(modifier = Modifier.padding(top = 10.dp), isHorizontal = true)
            arrayListOf<String>().orSize()
            val tags =
                listOf("Android", "Kotlin", "Jetpack Compose", "Material Design", "UI", "Development","KMP")

            PkFlowRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalSpacing = 8.dp,
                verticalSpacing = 12.dp,
                maxLine = 1
            ) {
                tags.forEach { tag ->
                    Text(
                        text = tag,
                        modifier = Modifier
                            .background(Color.LightGray, RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CustomRow(title: String, content: @Composable () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            title,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 10.dp)
        )
        content()
    }
}

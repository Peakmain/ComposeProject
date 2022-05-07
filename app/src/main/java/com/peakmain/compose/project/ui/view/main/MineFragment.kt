package com.peakmain.compose.project.ui.view.main

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：我的
 */
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.peakmain.compose.project.R
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_2DCDF5
import com.peakmain.compose.project.viewmodel.mine.MineFragmentViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel;
import com.peakmain.compose.project.ui.item.MineItemCell

@Composable
fun MineFragment(viewModel: MineFragmentViewModel = viewModel()) {
    var statusBarHeight = 0
    var statusBarHeightDp: Dp
    val headHeight = 200.dp
    with(LocalContext.current) {
        statusBarHeight =
            resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height",
                "dimen",
                "android"))
    }
    with(LocalDensity.current) {
        statusBarHeightDp = statusBarHeight.toDp()
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color.Transparent)
    }
    Column(modifier = Modifier
        .background(Color(0x66999999))
        .fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(headHeight + statusBarHeightDp)
            .background(Brush.linearGradient(listOf(Color_149EE7, Color_2DCDF5))),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.portrair),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(62.dp)
                    .clip(
                        CircleShape))
            Text(text = "peakmain",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp))
        }
        Column() {
            viewModel.mineItemBeans.forEachIndexed { index, it ->
                MineItemCell(
                    index,
                    mineItemBean = it,
                    viewModel.mineItemBeans.size,
                    modifier=Modifier.clickable {
                        //点击事件
                        Log.e("TAG","点击事件")
                    }
                )
            }

        }
    }
}


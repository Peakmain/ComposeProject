package com.peakmain.compose.project.ui.view.main

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：我的
 */
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.More
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.peakmain.compose.library.Banner
import com.peakmain.compose.library.TopAppBarCenter
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_2DCDF5
import com.peakmain.compose.project.ui.theme.Color_999999
import com.peakmain.compose.project.viewmodel.HomeFragmentViewModel

@Composable
fun MineFragment(viewModel: HomeFragmentViewModel = viewModel()) {
    val context: Context
    with(LocalContext.current) {
        context = this
    }
    TopAppBarCenter(
        title = {
            Text(text = "我的", color = Color.White)
        },
        isImmersive = true,
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "点击了返回", Toast.LENGTH_LONG).show()
                }, tint = Color.White)
        },
        actions = {
            Icon(imageVector = Icons.Default.FontDownload,
                contentDescription = null,
                tint = Color.White)
        },
        modifier = Modifier.background(Brush.linearGradient(listOf(Color_149EE7, Color_2DCDF5)))
    ) {
        Banner(
            data = viewModel.bannerData,//设置数据
            onImagePath = {//设置图片的url地址
                viewModel.bannerData[it].imagePath
            },
            isShowPagerIndicator = true,
            pagerIndicatorModifier = Modifier
                .background(Color(0x90000000))
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp, bottom = 10.dp),//指示器Row的整个样式,
            activeColor = Color.Red,
            inactiveColor = Color.Yellow,
            isLoopBanner = false,
            pagerModifier = Modifier
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(18.dp)),
            desc = {
                Text(text = "desc",color=Color.White)
            }
        ) {
            //设置item的点击事件
            Log.e("TAG", viewModel.bannerData[it].imagePath)
        }
    }

}


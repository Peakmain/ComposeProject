package com.peakmain.compose.project.ui.view.main

/**
 * author ：Peakmain
 * createTime：2022/5/2
 * mail:2726449200@qq.com
 * describe：
 */
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.peakmain.compose.library.Banner
import com.peakmain.compose.library.TopAppBarCenter
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_2DCDF5
import com.peakmain.compose.project.viewmodel.HomeFragmentViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeFragment(viewModel: HomeFragmentViewModel = viewModel()) {
    TopAppBarCenter(title = {
        Text(text = "首页", color = Color.White)
    },
        isImmersive = true,
        modifier = Modifier.background(Brush.linearGradient(listOf(Color_149EE7, Color_2DCDF5)))) {

        Column {
            Banner(
                data = viewModel.bannerData,//设置数据
                onImagePath = {//设置图片的url地址
                    viewModel.bannerData[it].imagePath
                },
                pagerModifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(8.dp)),//HorizontalPager的modifier
                pagerIndicatorModifier = Modifier
                    .background(Color(0x90000000))
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp, bottom = 10.dp),//指示器Row的整个样式
                desc = {
                    //指示器文本内容，也就是标题一、标题二
                    Text(text = viewModel.bannerData[it].desc, color = Color.White)
                }
            ) {
                //设置item的点击事件
                Log.e("TAG", viewModel.bannerData[it].imagePath)
            }

            Text(text = "我是首页", modifier = Modifier.padding(top = 10.dp))
        }
    }
}


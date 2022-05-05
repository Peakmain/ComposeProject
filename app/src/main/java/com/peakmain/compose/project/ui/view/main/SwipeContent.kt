package com.peakmain.compose.project.ui.view.main

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.peakmain.compose.project.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.launch
import java.util.*

/**
 * author ：Peakmain
 * createTime：2022/4/30
 * mail:2726449200@qq.com
 * describe：
 */
@ExperimentalPagerApi
@Composable
fun SwipeContent(vm: HomeFragmentViewModel) {
    val virtualCount = Int.MAX_VALUE

    val actualCount = vm.bannerData.size
    //初始图片下标
    val initialIndex = virtualCount / 2
    val pageState = rememberPagerState(initialPage = initialIndex)
    val coroutineScope= rememberCoroutineScope()
    DisposableEffect(Unit) {
        val timer = Timer()
        timer.schedule(object :TimerTask(){
            override fun run() {
                 coroutineScope.launch {
                     pageState.animateScrollToPage(pageState.currentPage+1)
                 }
            }

        },3000,3000)
        onDispose {
            timer.cancel()
        }
    }
    HorizontalPager(count = virtualCount,
        state = pageState,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clip(
                RoundedCornerShape(8.dp))) { index ->
        val actualIndex = (index - initialIndex).floorMod(actualCount)
        AsyncImage(model = vm.bannerData[actualIndex].imagePath,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 3f),
            contentScale = ContentScale.Crop)
    }
}

 fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other = other) * other
}
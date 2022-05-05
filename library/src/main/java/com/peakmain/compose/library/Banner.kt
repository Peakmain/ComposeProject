package com.peakmain.compose.library

/**
 * author ：Peakmain
 * createTime：2022/5/5
 * mail:2726449200@qq.com
 * describe：轮播图封装
 */
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.peakmain.compose.bean.BannerBean
import com.peakmain.compose.extends.floorMod
import kotlinx.coroutines.launch
import java.util.*

/**
 * @param data 数据来源
 * @param pagerModifier HorizontalPager的Modifier
 * @param ratio 图片宽高压缩比
 * @param contentScale 图片裁剪方式
 * @param isShowPagerIndicator 是否显示指示器
 * @param pagerIndicatorModifier 指示器Row的整个样式
 * @param activeColor 选中的指示器样式
 * @param inactiveColor 未选中的指示器样式
 * @param isLoopBanner 是否自动播放轮播图
 * @param loopDelay 任务执行前的延迟（毫秒）
 * @param loopPeriod 连续任务执行之间的时间（毫秒）。
 * @param horizontalArrangement 指示器Row中文本和指示器的排版样式
 * @param desc 文本内容
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(
    data: List<BannerBean>,
    pagerModifier: Modifier = Modifier,
    ratio: Float = 7 / 3f,
    contentScale: ContentScale = ContentScale.Crop,
    isShowPagerIndicator: Boolean = true,
    pagerIndicatorModifier: Modifier = Modifier,
    activeColor: Color = Color.White,
    inactiveColor: Color = Color(0xFF999999),
    isLoopBanner: Boolean = true,
    loopDelay: Long = 3000,
    loopPeriod: Long = 3000,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    desc: @Composable (Int) -> Unit,
) {
    val virtualCount = Int.MAX_VALUE

    val actualCount = data.size
    //初始图片下标
    val initialIndex = virtualCount / 2
    val pageState = rememberPagerState(initialPage = initialIndex)
    if (isLoopBanner) {
        val coroutineScope = rememberCoroutineScope()
        DisposableEffect(Unit) {
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    coroutineScope.launch {
                        pageState.animateScrollToPage(pageState.currentPage + 1)
                    }
                }

            }, loopDelay, loopPeriod)
            onDispose {
                timer.cancel()
            }
        }
    }
    val constraintSet = ConstraintSet {
        val image = createRefFor("image")
        val content = createRefFor("content")
        constrain(image) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(content) {
            bottom.linkTo(image.bottom)
            start.linkTo(image.start)
        }
    }
    HorizontalPager(count = virtualCount,
        state = pageState,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .then(pagerModifier)) { index ->
        val actualIndex = (index - initialIndex).floorMod(actualCount)
        ConstraintLayout(constraintSet = constraintSet) {
            AsyncImage(
                model = data[actualIndex].imagePath,
                contentDescription = null,
                modifier = Modifier
                    .layoutId("image")
                    .aspectRatio(ratio),
                contentScale = contentScale,
            )
            if (isShowPagerIndicator) {
                Row(Modifier
                    .layoutId("content")
                    .fillMaxWidth()
                    .then(pagerIndicatorModifier),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = horizontalArrangement
                ) {
                    desc(actualIndex)
                    HorizontalPagerIndicator(
                        pagerState = pageState,
                        activeColor = activeColor,
                        inactiveColor = inactiveColor,
                        count =actualCount
                    )
                }

            }
        }
    }
}



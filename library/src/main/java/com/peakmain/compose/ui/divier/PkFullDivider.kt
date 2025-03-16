package com.peakmain.compose.ui.divier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * author ：Peakmain
 * createTime：2025/3/7
 * mail:2726449200@qq.com
 * describe：垂直分割线
 */


/**
 * 创建一个实线分隔线组件。
 *
 * @param modifier 用于添加额外修饰符的 Modifier。
 * @param color 分隔线的颜色，默认为 0xFFF1EFE9。
 * @param height 分隔线的高度，默认为 28.dp。
 * @param thickness 分隔线的厚度，默认为 1.dp。
 * @param startIndent 分隔线的起始缩进，默认为 0.dp。
 * @param isHorizontal 水平分割线(true)/垂直分割线(false)，默认是false
 */
@Composable
fun PkFullDivider(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFF1EFE9),
    height:Dp=28.dp,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
    isHorizontal: Boolean=false
) {
    val indentMod = if (startIndent.value != 0f) {
        Modifier.padding(start = startIndent)
    } else {
        Modifier
    }
    val targetThickness = if (thickness == Dp.Hairline) {
        (1f / LocalDensity.current.density).dp
    } else {
        thickness
    }
    if(isHorizontal){
        Box(
            modifier.then(indentMod)
                .fillMaxWidth()
                .height(targetThickness)
                .background(color = color)
        )
    }else{
        Box(
            modifier.then(indentMod)
                .height(height)
                .width(targetThickness)
                .background(color = color)
        )
    }

}
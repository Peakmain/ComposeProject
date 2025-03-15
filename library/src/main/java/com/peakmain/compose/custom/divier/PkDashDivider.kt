package com.peakmain.compose.custom.divier

/**
 * author ：Peakmain
 * createTime：2025/3/6
 * mail:2726449200@qq.com
 * describe：
 */
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 虚线分隔线(支持水平/垂直)
 *
 * @param modifier 用于添加额外修饰符的 Modifier。
 * @param color 虚线的颜色，默认为 0x67272A2B。
 * @param strokeWidth 虚线的宽度，默认为 0.5.dp。
 * @param dashLength 虚线的长度，默认为 2.dp。
 * @param gapLength 虚线之间的间隔长度，默认为 2.dp。
 * @param isHorizontal  水平分割线(true)/垂直分割线(false)，默认是false
 */
@Composable
fun PkDashDivider(
    modifier: Modifier = Modifier,
    color: Color = Color(0x67272A2B),
    strokeWidth: Dp = 0.5.dp,
    dashLength: Dp = 2.dp,
    gapLength: Dp = 2.dp,
    isHorizontal: Boolean = false,
) {
    val newModifier = if (isHorizontal) modifier
        .fillMaxWidth()
        .height(strokeWidth) else modifier
        .fillMaxHeight()
        .width(strokeWidth)
    androidx.compose.foundation.Canvas(
        newModifier
    ) {
        val stroke = Stroke(
            width = strokeWidth.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashLength.toPx(), gapLength.toPx())
            )
        )
        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = stroke.width,
            pathEffect = stroke.pathEffect
        )
    }

}

@Preview
@Composable
fun DashDividerPreview() {
    PkDashDivider()
}

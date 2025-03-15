package com.peakmain.compose.custom.divier

/**
 * author ：Peakmain
 * createTime：2025/3/15
 * mail:2726449200@qq.com
 * describe：分割线
 */
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 根据 isDash 参数绘制虚线或完整的分隔线。
 *
 * @param modifier 用于添加额外修饰符的 Modifier。
 * @param color 分隔线的颜色，默认为 0xFFF1EFE9。
 * @param height 分隔线的高度，仅在垂直分隔线且非虚线时生效，默认为 28.dp。
 * @param thickness 分隔线的厚度，仅在非虚线时生效，默认为 1.dp。
 * @param startIndent 分隔线的起始缩进，仅在非虚线时生效，默认为 0.dp。
 * @param isHorizontal 是否为水平分隔线，默认为 false。
 * @param isDash 是否绘制虚线分隔线，默认为 false。
 * @param strokeWidth 虚线的宽度，仅在绘制虚线时生效，默认为 0.5.dp。
 * @param dashLength 虚线的线段长度，仅在绘制虚线时生效，默认为 2.dp。
 * @param gapLength 虚线的间隔长度，仅在绘制虚线时生效，默认为 2.dp。
 */
@Composable
fun PkDivider(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFF1EFE9),
    height: Dp = 28.dp,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp,
    isHorizontal: Boolean = false,
    isDash: Boolean = false,
    strokeWidth: Dp = 0.5.dp,
    dashLength: Dp = 2.dp,
    gapLength: Dp = 2.dp,
) {
    if (isDash) {
        PkDashDivider(
            modifier = modifier,
            color = color,
            strokeWidth = strokeWidth,
            dashLength = dashLength,
            gapLength = gapLength,
            isHorizontal = isHorizontal
        )
    } else {
        PkFullDivider(
            modifier = modifier,
            color = color,
            height = height,
            thickness = thickness,
            startIndent = startIndent,
            isHorizontal = isHorizontal
        )
    }
}

@Preview
@Composable
fun PkDividerPreview() {
    PkDivider()
}

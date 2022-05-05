package com.peakmain.compose.extends

/**
 * author ：Peakmain
 * createTime：2022/5/5
 * mail:2726449200@qq.com
 * describe：
 */
fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}
package com.peakmain.compose.ui

import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * author ：Peakmain
 * createTime：2022/2/9
 * mail:2726449200@qq.com
 * describe：GridLayout的实现
 */
/**
 * @param columns 1行几个
 * @param data 源数据
 * @param isShowHorizontalDivider 是否显示水平分割线，默认不显示
 * @param propagateMinConstraints 以Text为例false则居左，true则表示居中
 * @param content The content of the GridLayout
 */
@Composable
fun <E> GridLayout(
    @IntRange(from = 1) columns: Int,
    data: MutableList<E>,
    propagateMinConstraints: Boolean = false,
    isShowHorizontalDivider: Boolean = false,
    divider: @Composable (() -> Unit)? = null,
    content: @Composable (Int) -> Unit,
) {
    val size = data.size
    val rows = (size + columns - 1) / columns
    LazyColumn {
        items(rows) { rowIndex ->
            Row {
                for (columnIndex in 0 until columns) {
                    val itemIndex = rowIndex * columns + columnIndex
                    if (itemIndex < size) {
                        Box(
                            Modifier.weight(1f),
                            propagateMinConstraints = propagateMinConstraints
                        ) {
                              content(itemIndex)
                        }

                    } else {
                        Spacer(
                            Modifier
                                .weight(1f)
                        )
                    }
                }
            }
            if (isShowHorizontalDivider && rowIndex < (rows - 1)) {
                if (divider != null) {
                    divider()
                } else {
                    Divider(thickness = 0.5.dp)
                }
            }

        }
    }
}
package com.peakmain.compose.bean

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

/**
 * author ：Peakmain
 * createTime：2022/1/29
 * mail:2726449200@qq.com
 * describe：
 */
data class TextBean(
    var text: String? = null,
    var color: Color = Color.Unspecified,
    var fontSize: TextUnit = TextUnit.Unspecified,
    var fontStyle: FontStyle? = null,
    var fontWeight: FontWeight? = null,
    var fontFamily: FontFamily? = null,
    var letterSpacing: TextUnit = TextUnit.Unspecified,
    var textDecoration: TextDecoration? = null,
    var textAlign: TextAlign? = null,
    var lineHeight: TextUnit = TextUnit.Unspecified,
    var overflow: TextOverflow = TextOverflow.Clip,
    var softWrap: Boolean = true,
    var maxLines: Int = Int.MAX_VALUE,
    var onTextLayout: (TextLayoutResult) -> Unit = {},
    var style: TextStyle? = null,
    var modifier: Modifier = Modifier,
    var thenModifier: Modifier = Modifier,
    var enable:Boolean=true,
    var onClick: (() -> Unit)? = null,
)


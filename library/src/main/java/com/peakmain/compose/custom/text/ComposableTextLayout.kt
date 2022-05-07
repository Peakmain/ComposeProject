package com.peakmain.compose.custom.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.peakmain.compose.bean.TextBean

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：
 */
@Composable
fun ComposableText(bean: TextBean?): Unit? {
    return if (bean == null) {
        null
    } else {
        Text(
            text = bean.text!!,
            color = bean.color,
            fontSize = bean.fontSize,
            fontStyle = bean.fontStyle,
            fontWeight = bean.fontWeight,
            fontFamily = bean.fontFamily,
            letterSpacing = bean.letterSpacing,
            textDecoration = bean.textDecoration,
            textAlign = bean.textAlign,
            lineHeight = bean.lineHeight,
            overflow = bean.overflow,
            softWrap = bean.softWrap,
            maxLines = bean.maxLines,
            onTextLayout = bean.onTextLayout,
            style = if (bean.style != null) bean.style!! else LocalTextStyle.current,
            modifier = bean.modifier
                .clickable(enabled = bean.enable) {
                    bean.onClick?.invoke()
                }
                .then(bean.thenModifier)
        )
    }

}
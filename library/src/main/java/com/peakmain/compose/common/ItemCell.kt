package com.peakmain.compose.common

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：单元格
 */
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.peakmain.compose.bean.IconBean
import com.peakmain.compose.bean.TextBean
import com.peakmain.compose.custom.icon.ComposableIcon
import com.peakmain.compose.custom.text.ComposableText

@Composable
fun ItemCell(
    modifier: Modifier = Modifier,
    title: TextBean,
    iconBean: IconBean? = null,
    value: TextBean? = null,
    arrowBean: IconBean? = null,

    ) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        ComposableIcon(bean = iconBean)
        title.modifier = title.modifier.weight(1f)
        ComposableText(bean = title)
        if (value != null) {
            value.modifier= value.modifier.weight(1f)
            value.textAlign= TextAlign.End
            ComposableText(bean = value)
        }
        ComposableIcon(bean = arrowBean)
    }
}


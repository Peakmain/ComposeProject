package com.peakmain.compose.bean

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：
 */
data class IconBean(
    //官方的图标库
    var imageVector: ImageVector? = null,
    // drawable 里面的图片
    var painterResourceId: Int = 0,
    //ImageBitmap
    var imageBitmapId: Int = 0,
    var contentDescriptor: String? = null,
    var modifier: Modifier = Modifier,
    var tint: Color? = null,
    var onClick: (() -> Unit)? = null,
    var enable:Boolean = true,
)
package com.peakmain.compose.ui.icon

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：
 */
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import com.peakmain.compose.bean.IconBean
@Composable
fun ComposableIcon(bean: IconBean?): Unit? {
    return if (bean == null) {
        null
    } else {
        IconButton(onClick = {
            if (bean.onClick != null) {
                bean.onClick!!()
            }
        }) {
            if (bean.imageVector != null) {
                Icon(
                    imageVector = bean.imageVector!!,
                    contentDescription = bean.contentDescriptor,
                    tint = bean.tint
                        ?: LocalContentColor.current.copy(alpha = DefaultAlpha),
                    modifier = bean.modifier
                )
            } else if (bean.painterResourceId != 0) {
                Icon(
                    painterResource(id = bean.painterResourceId),
                    contentDescription = bean.contentDescriptor,
                    tint = bean.tint
                        ?: LocalContentColor.current.copy(alpha = DefaultAlpha),
                    modifier = bean.modifier
                )
            } else {
                if (bean.imageBitmapId != 0) {
                    var bitmap: ImageBitmap? = null
                    with(LocalContext.current) {
                        bitmap = ImageBitmap.imageResource(resources, bean.imageBitmapId)
                    }
                    bitmap?.let {
                        Icon(bitmap = it,
                            contentDescription = bean.contentDescriptor,
                            tint = bean.tint
                                ?: LocalContentColor.current.copy(alpha = DefaultAlpha),
                            modifier = bean.modifier)
                    }
                }
            }

        }
    }

}


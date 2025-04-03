package com.peakmain.compose.utils

import android.text.TextUtils
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.peakmain.compose.library.R

/**
 * author ：Peakmain
 * createTime：2025/3/6
 * mail:2726449200@qq.com
 * describe：图片加载工具类
 */
object ImagePainterUtils {
    /**
     * 根据图片 URL 获取 AsyncImagePainter 对象。
     *
     * @param imageUrl 图片的 URL，如果为空则显示占位图。
     * @param errorDrawableResId 图片加载失败时显示的 Drawable 资源 ID，默认为 R.drawable.icon_loading。
     * @param placeDrawableResId 图片加载过程中显示的占位图 Drawable 资源 ID，默认为 R.drawable.icon_loading。
     * @return 返回一个 AsyncImagePainter 对象。
     */
    @Composable
    fun getPainter(
        imageUrl: String?,
        @DrawableRes errorDrawableResId: Int = R.drawable.icon_loading,
        @DrawableRes placeDrawableResId: Int = R.drawable.icon_loading,
    ): AsyncImagePainter {

        return if (!TextUtils.isEmpty(imageUrl))
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .error(errorDrawableResId)
                    .placeholder(placeDrawableResId)
                    .build()
            ) else
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(placeDrawableResId)
                    .build()
            )

    }

}
package com.peakmain.compose.project.viewmodel.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.peakmain.compose.project.bean.home.BannerBean

/**
 * author ：Peakmain
 * createTime：2022/5/5
 * mail:2726449200@qq.com
 * describe：
 */
class HomeFragmentViewModel : ViewModel() {

    val bannerData by mutableStateOf(
        listOf(
            BannerBean("http://img.ahhuabang.com/data/banner/phone20220429gtvjsq.jpg","标题一"),
            BannerBean("http://img.ahhuabang.com/data/banner/phone20220429plqcyr.jpg","标题二"),
            BannerBean("http://img.ahhuabang.com/data/banner/phone20220429taojjf.jpg","标题三"),
            BannerBean("http://img.ahhuabang.com/data/banner/phone20220422aeoihx.jpg","标题四"),
        )
    )


}
package com.peakmain.compose.project.viewmodel.mine

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.peakmain.compose.project.bean.mine.MineItemBean

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：
 */
class MineFragmentViewModel :ViewModel(){
    val mineItemBeans by mutableStateOf(
        listOf(
            MineItemBean("我的收藏",Icons.Default.ThumbUp),
            MineItemBean("积分排行",Icons.Default.WorkspacePremium),
            MineItemBean("设置",Icons.Default.Settings),

        )
    )
}
package com.peakmain.compose.project.ui.item

/**
 * author ：Peakmain
 * createTime：2022/5/7
 * mail:2726449200@qq.com
 * describe：
 */
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.peakmain.compose.bean.IconBean
import com.peakmain.compose.bean.TextBean
import com.peakmain.compose.common.ItemCell
import com.peakmain.compose.project.bean.mine.MineItemBean
import com.peakmain.compose.project.ui.theme.Color_149EE7
import com.peakmain.compose.project.ui.theme.Color_323233
import com.peakmain.compose.project.ui.theme.Color_969799
import com.peakmain.compose.project.ui.theme.Color_D1D1D1

@Composable
fun MineItemCell(
    index: Int,
    mineItemBean: MineItemBean,
    size: Int,
    modifier: Modifier = Modifier,
) {
    Column() {
        ItemCell(
            modifier = modifier
                .background(Color.White)
                .padding(start = 20.dp, end = 10.dp)
                .padding(
                    top = if (index == 0) 40.dp else 20.dp,
                    bottom = 20.dp
                ),
            iconBean = IconBean(
                mineItemBean.icon,
                modifier = Modifier.padding(end = 8.dp),
                tint = Color_149EE7),
            title = TextBean(mineItemBean.title, color = Color_323233, thenModifier = modifier),
            arrowBean = IconBean(Icons.Default.KeyboardArrowRight, tint = Color_969799))
        if (index < (size - 1)) {
            Divider(modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(0.5.dp)
                .background(
                    Color_D1D1D1))
        }
    }
}



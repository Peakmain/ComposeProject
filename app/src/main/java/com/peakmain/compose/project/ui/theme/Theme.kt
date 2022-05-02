package com.peakmain.compose.project.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Color_149EE7,
    primaryVariant = Color_149EE7,
    secondary = Color_2DCDF5
)

@Composable
fun ComposeProjectTheme(
    content: @Composable() () -> Unit,
) {
    val colors =
        LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
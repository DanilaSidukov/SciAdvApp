package com.diphrogram.sciadvapp.theme

import androidx.annotation.RequiresPermission
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object SciAdvTheme {
    val colors: SciAdvColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SciAdvTypography
        @Composable
        @RequiresPermission.Read
        get() = LocalTypography.current
}

internal val LocalColors = staticCompositionLocalOf { LightColors }
internal val LocalTypography = staticCompositionLocalOf { SciAdvTypography() }
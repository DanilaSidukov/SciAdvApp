package com.diphrogram.sciadvapp.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val darkBlue = Color(0xFF222F3E)
private val white = Color.White

data class SciAdvColors(
    val material: ColorScheme,
    private val primaryColor: Color,
    private val primaryOnColor: Color

    ){
    val primary: Color get() = material.primary
    val background: Color get() = primaryColor
    val whiteColor: Color get() = white
    val generalText: Color get() = primaryOnColor
}

val LightColors = SciAdvColors(
    material = lightColorScheme(),
    primaryColor = darkBlue,
    primaryOnColor = white
)
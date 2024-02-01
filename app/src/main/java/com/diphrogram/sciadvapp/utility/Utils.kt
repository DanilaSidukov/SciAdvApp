package com.diphrogram.sciadvapp.utility

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.diphrogram.sciadvapp.ui.screens.widgets.ChaosHeadTitleStyle

@Composable
fun getEntryText(entryName: String) {
    return when (entryName){
        "Chaos;Head Series" -> ChaosHeadTitleStyle(
            title = entryName,
            titleColor = Color.Black,
            borderColor = Color.White,
            isBordered = true,
            modifier = Modifier
        )
        else -> { }
        }
    }
package com.diphrogram.sciadvapp.ui.screens.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.diphrogram.sciadvapp.theme.ChaosHeadNoAHEntryStyle
import com.diphrogram.sciadvapp.theme.TuersCardboardStyle

@Composable
fun ChaosHeadTitleStyle(
    modifier: Modifier,
    title: String,
    isBordered: Boolean,
    titleColor: Color,
    borderColor: Color
) {
    if (isBordered) {
        Box {
            Text(
                modifier = modifier,
                text = title,
                style = ChaosHeadNoAHEntryStyle(FontWeight.Normal, 20.sp),
                color = borderColor,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = modifier,
                text = title,
                style = TuersCardboardStyle(FontWeight.Normal, 20.sp),
                color = titleColor,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Box {
            Text(
                modifier = modifier,
                text = title,
                style = TuersCardboardStyle(FontWeight.Normal, 20.sp),
                color = titleColor,
                textAlign = TextAlign.Center
            )
        }
    }
}
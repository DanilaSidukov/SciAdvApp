package com.diphrogram.sciadvapp.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.diphrogram.sciadvapp.R

val LeagueGothicFamily = FontFamily(
    Font(R.font.league_gothic_regular)
)

val InterFamily = FontFamily(
    Font(R.font.inter_bold),
    Font(R.font.inter_medium),
    Font(R.font.inter_regular),
    Font(R.font.inter_light)
)

val TuersCardboard = FontFamily(
    Font(R.font.tuers_cardboard)
)

internal fun LeagueGothicFamilyStyle(weight: FontWeight, size: TextUnit = 16.sp) =
    TextStyle(
        fontFamily = LeagueGothicFamily,
        fontWeight = weight,
        fontSize = size
    )

data class SciAdvTypography(
    val material: Typography = Typography(),
    val leagueGothicTextTitle: TextStyle = LeagueGothicFamilyStyle(FontWeight.Normal, 22.sp)
    )
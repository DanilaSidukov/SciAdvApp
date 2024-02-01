package com.diphrogram.sciadvapp.utility

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.diphrogram.sciadvapp.R
import com.diphrogram.sciadvapp.data.EntitiesName

fun EntitiesName.asString(context: Context): String {
    return when(this){
        EntitiesName.CHAOS_HEAD -> context.getString(R.string.chaos_head)
        EntitiesName.STEINS_GATE -> context.getString(R.string.steins_gate)
        EntitiesName.CHAOS_CHILD -> context.getString(R.string.chaos_child)
        EntitiesName.OCCULTIC_NINE -> context.getString(R.string.occultic_nine)
        EntitiesName.ROBOTICS_NOTES -> context.getString(R.string.robotics_notes)
        EntitiesName.ANONYMOUS_CODE -> context.getString(R.string.anonymous_code)
    }
}

fun String.getColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}
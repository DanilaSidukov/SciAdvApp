package com.diphrogram.sciadvapp.utility

import com.diphrogram.sciadvapp.data.ENTRIES_KEY
import com.diphrogram.sciadvapp.data.ENTRY_KEY

sealed class Screen(val route: String) {
    object Entries: Screen(ENTRIES_KEY)
    object Entry: Screen(ENTRY_KEY)
}

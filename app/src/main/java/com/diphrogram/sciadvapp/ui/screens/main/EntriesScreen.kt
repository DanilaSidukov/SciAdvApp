package com.diphrogram.sciadvapp.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diphrogram.sciadvapp.R
import com.diphrogram.sciadvapp.data.ENTRY_KEY
import com.diphrogram.sciadvapp.data.EntitiesName
import com.diphrogram.sciadvapp.theme.SciAdvTheme
import com.diphrogram.sciadvapp.utility.Screen
import com.diphrogram.sciadvapp.utility.asString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntriesScreen(
    navHostController: NavController
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .background(SciAdvTheme.colors.background)
                    .statusBarsPadding()
                    .padding(top = 16.dp, bottom = 21.dp),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.sci_adv_logo),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .size(width = 65.dp, height = 48.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.sci_adv_title),
                            style = SciAdvTheme.typography.leagueGothicTextTitle,
                            letterSpacing = 2.sp,
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = SciAdvTheme.colors.background,
                    titleContentColor = SciAdvTheme.colors.generalText
                ),
                actions = {

                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(top = it.calculateTopPadding())
                    .fillMaxSize()
                    .background(SciAdvTheme.colors.background)
            ) {
                EntriesList(
                    navHostController,
                    listOfEntities
                )
            }
        }
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EntriesList(
    navController: NavController,
    entityList: List<Pair<Int, EntitiesName>>
) {
    CompositionLocalProvider(
        LocalOverscrollConfiguration.provides(null)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 31.dp, end = 31.dp, bottom = 31.dp),
            horizontalArrangement = Arrangement.spacedBy(26.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp),
            content = {
                items(entityList.size) {
                    EntryItem(
                        navController,
                        entityList[it],
                    )
                }
            }
        )
    }
}

@Composable
fun EntryItem(
    navController: NavController,
    imageEntity: Pair<Int, EntitiesName>,
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .size(width = 143.dp, height = 228.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = ENTRY_KEY,
                    value = imageEntity.second.asString(context)
                )
                navController.navigate(Screen.Entry.route)
            },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = imageEntity.first),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }

}

@Composable
@Preview
fun preview() {
    EntriesScreen(rememberNavController())
}

val listOfEntities = listOf(
    Pair(R.drawable.chaos_head_cover, EntitiesName.CHAOS_HEAD),
    Pair(R.drawable.steins_gate_cover, EntitiesName.STEINS_GATE),
    Pair(R.drawable.chaos_child_cover, EntitiesName.CHAOS_CHILD),
    Pair(R.drawable.occultic_nine_cover, EntitiesName.OCCULTIC_NINE),
    Pair(R.drawable.robotics_notes_cover, EntitiesName.ROBOTICS_NOTES),
    Pair(R.drawable.anonymous_code_cover, EntitiesName.ANONYMOUS_CODE)
)
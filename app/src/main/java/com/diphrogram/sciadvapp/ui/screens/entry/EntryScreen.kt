package com.diphrogram.sciadvapp.ui.screens.entry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.diphrogram.sciadvapp.R
import com.diphrogram.sciadvapp.theme.SciAdvTheme
import com.diphrogram.sciadvapp.ui.screens.widgets.ChaosHeadTitleStyle
import com.diphrogram.sciadvapp.utility.getColor
import com.diphrogram.sciadvapp.utility.getEntryText
import com.google.accompanist.insets.statusBarsPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryScreen(
    navController: NavController,
    entryName: String,
    entryCoverColor: String,
    topBarColor: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(topBarColor.getColor())
                    .statusBarsPadding(),
                title = {
                    getEntryText(entryName = entryName)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF636E72)
                ),
                actions = {}
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(entryCoverColor.getColor())
                .padding(top = it.calculateTopPadding())
        ) {
            Column(
                modifier = Modifier
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(26.dp),
                    content = {
                        item(span = { GridItemSpan(2) }) {
                            EntryCoverImage(entryCoverColor = entryCoverColor)
                        }
                        SectionViewItem(
                            lazyGridScope = this,
                            sectionColor = "#D63031",
                            sectionName = "Visual Novels",
                            modifier = Modifier
                                .graphicsLayer {
                                    translationY = -(81).dp.value
                                }
                        )
                        ArtWorkGridItem(
                            lazyGridScope = this,
                            navController = navController,
                            covers = coverList,
                            titles = titleList
                        )
                        SectionViewItem(
                            lazyGridScope = this,
                            sectionColor = "#0984E3",
                            sectionName = "Anime",
                            modifier = Modifier
                                .padding(bottom = 34.dp)
                        )
                        ArtWorkGridItem(
                            lazyGridScope = this,
                            navController = navController,
                            covers = coverList,
                            titles = titleList
                        )
                        SectionViewItem(
                            lazyGridScope = this,
                            sectionColor = "#E17055",
                            sectionName = "Manga",
                            modifier = Modifier
                                .padding(bottom = 34.dp)
                        )
                        ArtWorkGridItem(
                            lazyGridScope = this,
                            navController = navController,
                            covers = coverList,
                            titles = titleList
                        )
                    }
                )

            }
        }
    }

}

@Composable
fun EntryCoverImage(entryCoverColor: String) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, entryCoverColor.getColor()),
        startY = sizeImage.height.toFloat() / 1.6f,
        endY = sizeImage.height.toFloat()
    )
    Box(
        modifier = Modifier
            .height(500.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .onGloballyPositioned {
                    sizeImage = it.size
                },
            painter = painterResource(id = R.drawable.chaos_head_cover),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
        )
    }
}

@Composable
fun SectionView(
    modifier: Modifier,
    sectionColor: String,
    sectionName: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = sectionName,
            modifier = modifier
                .wrapContentWidth()
                .align(Alignment.CenterStart)
                .clip(RoundedCornerShape(topEnd = 25.dp, bottomEnd = 25.dp))
                .background(sectionColor.getColor())
                .padding(horizontal = 25.dp, vertical = 7.dp),
            color = SciAdvTheme.colors.generalText,
            fontSize = 20.sp
        )
    }


}

fun SectionViewItem(
    lazyGridScope: LazyGridScope,
    sectionColor: String,
    sectionName: String,
    modifier: Modifier
) = with(lazyGridScope) {
    item(span = { GridItemSpan(2) }) {
        SectionView(
            modifier = modifier,
            sectionColor = sectionColor,
            sectionName = sectionName
        )
    }
}

fun ArtWorkGridItem(
    lazyGridScope: LazyGridScope,
    navController: NavController,
    covers: List<Int>,
    titles: List<String>
) = with(lazyGridScope) {
    items(coverList.size) { index ->
        val modifier = if (index % 2 != 0) Modifier.padding(end = 31.dp, bottom = 26.dp)
        else Modifier.padding(start = 26.dp, bottom = 26.dp)
        ArtWorkItem(
            modifier = modifier,
            navController = navController,
            cover = covers[index],
            title = titles[index],
            titleColor = Color.Black
        )
    }
}

@Composable
fun ArtWorkItem(
    modifier: Modifier,
    navController: NavController,
    cover: Int,
    title: String,
    titleColor: Color
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(width = 143.dp, height = 228.dp)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                .clickable {

                },
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = cover),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        ArtWorkTitle(
            title = title,
            isBordered = true,
            isChaosHeadSeries = true,
            titleColor = titleColor,
            borderColor = Color.White
        )
    }

}

@Composable
fun ArtWorkTitle(
    title: String,
    isBordered: Boolean,
    isChaosHeadSeries: Boolean,
    titleColor: Color,
    borderColor: Color = Color.Transparent
) {
    if (isChaosHeadSeries) {
        ChaosHeadTitleStyle(
            modifier = Modifier
                .padding(top = 11.dp),
            title = title,
            isBordered = isBordered,
            titleColor = titleColor,
            borderColor = borderColor
        )
    }
}


@Preview
@Composable
fun entryPreview() {
    EntryScreen(
        entryName = "Chaos;Head Series",
        entryCoverColor = "#7C7C7E",
        topBarColor = "#7C7C7E",
        navController = rememberNavController()
    )
}

private val coverList = listOf(
    R.drawable.chaos_head_cover,
    R.drawable.chaos_head_vn_cover,
    R.drawable.chaos_head_love_chu_chu_cover
)

private val titleList = listOf(
    "Chaos;Head NoAH",
    "Chaos;Head",
    "Chaos;Head Love Chu Chu"
)
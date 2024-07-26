package com.example.ordersystem.ui.components

import PagingButton
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ordersystem.data.DESSERT_MENU
import com.example.ordersystem.data.NOODLE_MENU
import com.example.ordersystem.data.RICE_BOWL_MENU
import com.example.ordersystem.data.SUSHI_MENU
import com.example.ordersystem.uistate.HomeUiState
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun MenuPager(
    modifier: Modifier = Modifier,
    selectCurrentMenu: (Int, String, String, Int, Int) -> Unit,
    homeUiState: HomeUiState,
) {
    val itemsPerPage = 8
    val pageCount = (SUSHI_MENU.size + itemsPerPage - 1) / itemsPerPage
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val scope = rememberCoroutineScope()
    val category =
        when (homeUiState.currentMenuCategory) {
            "寿司" -> SUSHI_MENU
            "ご飯・丼" -> RICE_BOWL_MENU
            "麺" -> NOODLE_MENU
            "デザート" -> DESSERT_MENU
            else -> emptyList()
        }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState,
        ) { page ->
            val startIndex = page * itemsPerPage
            val endIndex = minOf(startIndex + itemsPerPage, category.size)
            val itemsForPage = category.subList(startIndex, endIndex)
            GridMenu(
                modifier = modifier,
                items = itemsForPage,
                selectCurrentMenu = selectCurrentMenu,
            )
        }
        Spacer(modifier = modifier.weight(1f))
        Row(
            modifier =
                modifier
                    .padding(start = 5.dp, end = 5.dp),
        ) {
            PagingButton(
                modifier = Modifier,
                isNext = false,
                text = "前へ",
                onClick = {
                    if (pagerState.currentPage > 0) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
            )
            Spacer(modifier.weight(1f))
            PagingButton(
                modifier = Modifier,
                text = "次へ",
                isNext = true,
                onClick = {
                    if (pagerState.currentPage < 10) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
@Preview
fun PreviewMenuPager() {
    MenuPager(
        modifier = Modifier,
        selectCurrentMenu = { id, name, price, imageResId, quantity -> },
        homeUiState = HomeUiState(),
    )
}

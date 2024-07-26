package com.example.ordersystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ordersystem.data.TOP_MENU
import com.example.ordersystem.ui.components.MenuPager
import com.example.ordersystem.ui.components.OrderScreen
import com.example.ordersystem.ui.components.TopMenu
import com.example.ordersystem.ui.components.VerticalDivider
import com.example.ordersystem.ui.theme.OrderSystemTheme
import com.example.ordersystem.uistate.HomeUiState
import com.example.ordersystem.viewmodel.HomeViewModel

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderSystemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val homeUiState = homeViewModel.homeUiState

                    Home(
                        modifier = Modifier,
                        selectCurrentMenu = { id, name, price, imageResId, quantity ->
                            homeViewModel.selectCurrentMenu(id = id, name = name, price = price, imageResId = imageResId, quantity = quantity)
                        },
                        addOrder = { id, name, price, imageResId, quantity ->
                            homeViewModel.addOrder(id = id, name = name, price = price, imageResId = imageResId, quantity = quantity)
                        },
                        homeUiState = homeUiState,
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Home(
    modifier: Modifier = Modifier,
    selectCurrentMenu: (Int, String, String, Int, Int) -> Unit,
    addOrder: (Int, String, String, Int, Int) -> Unit,
    homeUiState: HomeUiState,
) {
    // composableの背景用
    Box(
        modifier
            .fillMaxSize()
            .background(
                Color(red = 0, green = 0, blue = 0, alpha = 210),
            ),
    ) {
        // 　composable全体を包むRow
        Row(
            modifier.fillMaxWidth(),
        ) {
            // 左半分のcomposable
            Column(
                modifier =
                    modifier
                        .weight(8f)
                        .padding(top = 15.dp, bottom = 10.dp, start = 5.dp, end = 5.dp),
            ) {
                TopMenu(modifier = modifier, topMenu = TOP_MENU)
                MenuPager(modifier = modifier, selectCurrentMenu = selectCurrentMenu)
            }

            VerticalDivider(modifier = Modifier, thickness = 2.dp, color = Color.White)

            Box(
                modifier =
                    modifier
                        .weight(2f)
                        .fillMaxHeight(),
            ) {
                OrderScreen(
                    modifier = modifier,
                    homeUiState = homeUiState,
                    addOrder = addOrder,
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true, device = "id:pixel_tablet")
@Composable
fun GreetingPreview() {
    OrderSystemTheme {
        Home(
            modifier = Modifier,
            selectCurrentMenu = { id, name, price, imageResId, quantity -> },
            addOrder = { id, name, price, imageResId, quantity -> },
            homeUiState = HomeUiState(),
        )
    }
}

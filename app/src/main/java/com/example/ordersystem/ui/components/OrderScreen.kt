package com.example.ordersystem.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordersystem.data.SUSHI_MENU
import com.example.ordersystem.uistate.HomeUiState

@Composable
fun OrderScreen(
    modifier: Modifier,
    homeUiState: HomeUiState,
    addOrder: (Int, String, String, Int, Int) -> Unit,
) {
    val orderCount = 1
    // UI開発時の仮注文リスト
    val orderList = listOf("まぐろ", "さば", "たまご", "えび", "まぐろ", "さば", "たまご", "えび")

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Menu(
            modifier =
                modifier
                    .padding(2.dp),
            id = homeUiState.currentMenu.id,
            name = homeUiState.currentMenu.name,
            price = homeUiState.currentMenu.price,
            imageResId = homeUiState.currentMenu.imageResId,
            quantity = homeUiState.currentMenu.quantity,
            selectCurrentMenu = { id, name, price, imageResId, quantity -> },
        )

        Column(modifier.padding(10.dp)) {
            Row(
                modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = "${orderCount}皿",
                    fontSize = 40.sp,
                    color = Color.White,
                )
                Button(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    contentPadding = PaddingValues(5.dp),
                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black,
                        ),
                ) {
                    Text(
                        text = "ー",
                        fontSize = 34.sp,
                        color = Color.Black,
                    )
                }
                Button(
                    onClick = {
                        // Log.d("result", homeUiState.currentOrderList.toString() + "追加前")
                        addOrder(
                            homeUiState.currentMenu.id,
                            homeUiState.currentMenu.name,
                            homeUiState.currentMenu.price,
                            homeUiState.currentMenu.imageResId,
                            homeUiState.currentMenu.quantity
                        )
                        Log.d("result", homeUiState.currentOrderList.toString() + "追加後")
                    },
                    shape = CircleShape,
                    contentPadding = PaddingValues(5.dp),
                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black,
                        ),
                ) {
                    Text(
                        text = "＋",
                        fontSize = 34.sp,
                        color = Color.Black,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.White, shape = RoundedCornerShape(30.dp))
                    .border(
                        2.dp,
                        color = Color(218, 165, 32),
                        shape = RoundedCornerShape(30.dp),
                    ),
            ) {
                Text(
                    text = "注文リスト",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(15.dp),
                )
                LazyColumn(
                    modifier
                        .height(250.dp)
                        .padding(5.dp),
                ) {
                    itemsIndexed(orderList) { index, item ->
                        Row(modifier = modifier.padding(5.dp)) {
                            Text(
                                modifier = modifier.padding(5.dp),
                                text = item,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier =
                                    modifier
                                        .size(40.dp)
                                        .background(
                                            Color(218, 165, 32),
                                            shape = RoundedCornerShape(8.dp),
                                        )
                                        .padding(5.dp),
                            ) {
                                Text(
                                    text = "2",
                                    fontSize = 24.sp,
                                    color = White,
                                )
                            }
                        }
                        Divider(modifier.padding(start = 5.dp, end = 5.dp))
                    }
                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(Color(218, 165, 32)),
                    modifier =
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp),
                ) {
                    Text(
                        text = "注文を確定",
                        fontSize = 25.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOrderScreen() {
    OrderScreen(
        modifier = Modifier,
        addOrder = { id, name, price, imagaResId, quantity -> },
        homeUiState = HomeUiState(),
    )
}

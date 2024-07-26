package com.example.ordersystem.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ordersystem.R
import com.example.ordersystem.data.Menu

@Composable
fun GridMenu(
    modifier: Modifier,
    items: List<Menu>,
    selectCurrentMenu: (String, String, Int) -> Unit,
) {
    Column(
        Modifier,
    ) {
        for (i in items.indices step 4) {
            Row(Modifier) {
                for (j in 0 until 4) {
                    if (i + j < items.size) {
                        Menu(
                            Modifier.padding(2.dp),
                            name = items[i + j].name,
                            price = items[i + j].price,
                            imageResId = items[i + j].imageResId,
                            selectCurrentMenu = selectCurrentMenu,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Menu(
    modifier: Modifier,
    name: String,
    price: String,
    imageResId: Int,
    selectCurrentMenu: (String, String, Int) -> Unit,
) {
    Box(
        modifier
            .background(Color.White)
            .size(250.dp, 250.dp)
            .clickable {
                selectCurrentMenu(name, price, imageResId)
            },
    ) {
        // 値が初期値じゃないときにメニュー画像を表示
        if (name != "" && price != "" && imageResId != 0) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier =
                    modifier
                        .fillMaxWidth(),
            )
            Column(
                modifier =
                    modifier
                        .fillMaxHeight()
                        .padding(5.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = name,
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    modifier = modifier.padding(top = 5.dp),
                    text = price,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewMenu() {
    Column {
        Menu(
            modifier = Modifier,
            name = "ネギトロ丼",
            price = "700円",
            imageResId = R.drawable.negitoro_don,
            selectCurrentMenu = { name, price, imageResId -> },
        )
    }
}

package com.example.ordersystem.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopMenu(
    modifier: Modifier,
    topMenu: List<String>,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(60.dp),
    ) {
        for ((index, item) in topMenu.withIndex()) {
            Button(
                onClick = {},
                modifier.weight(1f),
                shape = CutCornerShape(0.dp),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),
            ) {
                Text(
                    text = item,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }
            if (index != 3) {
                VerticalDivider(
                    modifier.padding(
                        top = 5.dp,
                        bottom = 5.dp,
                    ),
                    thickness = 1.dp,
                    color = Color.Gray,
                )
            }
        }
    }
}

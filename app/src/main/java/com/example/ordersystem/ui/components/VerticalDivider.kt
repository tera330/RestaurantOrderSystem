package com.example.ordersystem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalDivider(
    modifier: Modifier,
    color: Color,
    thickness: Dp,
) {
    Box(
        modifier =
            modifier
                .width(thickness)
                .fillMaxHeight()
                .background(color),
    )
}

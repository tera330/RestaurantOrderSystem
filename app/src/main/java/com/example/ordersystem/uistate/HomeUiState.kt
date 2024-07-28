package com.example.ordersystem.uistate

import com.example.ordersystem.data.Menu

data class HomeUiState(
    val currentMenuCategory: String = "寿司",
    val currentMenu: Menu =
        Menu(
            id = -1,
            name = "",
            price = "",
            imageResId = 0,
            quantity = 0,
        ),
    var currentOrderList: List<Menu> = mutableListOf(),
    val totalOrderList: List<Menu> = mutableListOf(),
    val totalPrice: Int = 0,
)

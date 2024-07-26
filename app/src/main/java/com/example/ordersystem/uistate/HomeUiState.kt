package com.example.ordersystem.uistate

import com.example.ordersystem.data.Menu

data class HomeUiState(
    val currentMenu: Menu = Menu(
        id = -1, name = "", price = "", imageResId = 0, quantity = 0),
    var currentOrderList: MutableList<Menu> = mutableListOf(),
    val totalOrderList: MutableList<Menu> = mutableListOf(),
    val totalPrice: Int = 0,
)

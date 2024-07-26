package com.example.ordersystem.uistate

import com.example.ordersystem.data.Menu

data class HomeUiState(
    val currentMenu: Menu = Menu(name = "", price = "", imageResId = 0),
    val currentOrderList: MutableList<Menu> = mutableListOf(),
    val totalOrderList: MutableList<Menu> = mutableListOf(),
    val totalPrice: Int = 0,
)

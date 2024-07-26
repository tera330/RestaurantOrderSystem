package com.example.ordersystem.data

data class Menu(
    val id: Int,
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int,
)

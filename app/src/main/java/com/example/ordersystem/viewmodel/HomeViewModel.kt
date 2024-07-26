package com.example.ordersystem.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ordersystem.data.Menu
import com.example.ordersystem.uistate.HomeUiState

class HomeViewModel : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set

    // メニューが選択されたとき
    fun selectCurrentMenu(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int
    ) {
        Log.d("result", homeUiState.currentMenu.toString() + "変更前")
        homeUiState =
            homeUiState.copy(
                currentMenu =
                    Menu(
                        id = id,
                        name = name,
                        price = price,
                        imageResId = imageResId,
                        quantity =  quantity
                    ),
            )
        Log.d("result", homeUiState.currentMenu.toString() + "変更後")
    }

    // メニューが選択され、＋ボタンが押されたとき
    fun addOrder(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int
    ) {
        val newMenu = Menu(
            id = id,
            name = name,
            price = price,
            imageResId = imageResId,
            quantity = 1 // 注文リストに追加した時点で１つ以上になるため
        )

        val existingMenu = homeUiState.currentOrderList.find { it.id == id }
        if (existingMenu != null) {
            homeUiState.currentOrderList = homeUiState.currentOrderList.map {
                if (it.id == id) it.copy(quantity = it.quantity + 1) else it
            }.toMutableList()
        } else {
            homeUiState.currentOrderList = homeUiState.currentOrderList.toMutableList().apply {
                add(newMenu)
            }
        }
        homeUiState = homeUiState.copy(currentOrderList = homeUiState.currentOrderList)
    }

    // メニューが選択され、ーボタンが押されたとき
    fun removeOrder(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int
    ) {
        val removeMenu = Menu(
            id = id,
            name = name,
            price = price,
            imageResId = imageResId,
            quantity = quantity
        )

        /*
        homeUiState = homeUiState.copy(
            currentOrderList = homeUiState.currentOrderList.apply {
                add(newMenu)
            }
        )
         */
    }
}

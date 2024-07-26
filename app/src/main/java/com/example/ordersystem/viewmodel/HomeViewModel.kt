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
        name: String,
        price: String,
        imageResId: Int,
    ) {
        Log.d("result", homeUiState.currentMenu.toString() + "変更前")
        homeUiState =
            homeUiState.copy(
                currentMenu =
                    Menu(
                        name = name,
                        price = price,
                        imageResId = imageResId,
                    ),
            )
        Log.d("result", homeUiState.currentMenu.toString() + "変更後")
    }

    // メニューが選択され、＋ボタンが押されたとき
    fun addOrder(
        name: String,
        price: String,
        imageResId: Int,
    ) {
        val newMenu = Menu(name = name, price = price, imageResId = imageResId)

        homeUiState =
            homeUiState.copy(
                currentOrderList =
                    homeUiState.currentOrderList.apply {
                        add(newMenu)
                    },
            )
    }

    // メニューが選択され、ーボタンが押されたとき
    fun removeOrder(
        name: String,
        price: String,
        imageResId: Int,
    ) {
        val removeMenu = Menu(name = name, price = price, imageResId = imageResId)

        /*
        homeUiState = homeUiState.copy(
            currentOrderList = homeUiState.currentOrderList.apply {
                add(newMenu)
            }
        )
         */
    }
}

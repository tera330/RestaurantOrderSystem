package com.example.ordersystem.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ordersystem.data.Menu
import com.example.ordersystem.uistate.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private var _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    // メニューが選択されたとき
    fun selectCurrentMenu(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int,
    ) {
        Log.d("result", _homeUiState.value.currentMenu.toString() + "変更前")
        _homeUiState.value =
            homeUiState.value.copy(
                currentMenu =
                    Menu(
                        id = id,
                        name = name,
                        price = price,
                        imageResId = imageResId,
                        quantity = quantity,
                    ),
            )
        Log.d("result", homeUiState.value.currentMenu.toString() + "変更後")
    }

    // メニューが選択され、＋ボタンが押されたとき
    fun addOrder(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int,
    ) {
        val newMenu =
            Menu(
                id = id,
                name = name,
                price = price,
                imageResId = imageResId,
                quantity = 1,
            )

        val updatedOrderList =
            _homeUiState.value.currentOrderList.toMutableList().apply {
                val existingMenu = find { it.id == id }
                if (existingMenu != null) {
                    val updatedMenu = existingMenu.copy(quantity = existingMenu.quantity + 1)
                    remove(existingMenu)
                    add(updatedMenu)
                } else {
                    add(newMenu)
                }
            }
        val updateCurrentMenu =
            _homeUiState.value.currentMenu.copy(
                quantity = updatedOrderList.find { it.id == id }?.quantity ?: 0,
            )

        _homeUiState.update { currentState ->
            currentState.copy(
                currentOrderList = updatedOrderList,
                currentMenu = updateCurrentMenu,
            )
        }
    }

    // ーボタンを押されたとき
    fun removeOrder(
        id: Int,
        name: String,
        price: String,
        imageResId: Int,
        quantity: Int,
    ) {
        val updatedOrderList =
            _homeUiState.value.currentOrderList.toMutableList().apply {
                val existingMenu = find { it.id == id }
                if (existingMenu != null && existingMenu.quantity > 0) {
                    val updatedMenu = existingMenu.copy(quantity = existingMenu.quantity - 1)
                    remove(existingMenu)
                    add(updatedMenu)
                }
            }
        val updateCurrentMenu =
            _homeUiState.value.currentMenu.copy(
                quantity = updatedOrderList.find { it.id == id }?.quantity ?: 0,
            )

        _homeUiState.update { currentState ->
            currentState.copy(
                currentOrderList = updatedOrderList,
                currentMenu = updateCurrentMenu,
            )
        }
    }

    // メニューカテゴリの変更
    fun selectCategory(category: String) {
        _homeUiState.value =
            _homeUiState.value.copy(
                currentMenuCategory = category,
            )
    }
}

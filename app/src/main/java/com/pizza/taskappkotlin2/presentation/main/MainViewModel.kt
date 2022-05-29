package com.pizza.taskappkotlin2.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pizza.taskappkotlin2.data.repository.ShopListRepositoryImpl
import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.useCases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()
    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    val shopListLD = getShopListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        viewModelScope.launch(Dispatchers.IO) {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun editShopItem(shopItem: ShopItem) {
        viewModelScope.launch(Dispatchers.IO) {
            val newItem = with(shopItem) { copy(enabled = !enabled) }
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    fun getShopItem(shopItem: Int): ShopItem? {
        var data: ShopItem? = null
        viewModelScope.launch(Dispatchers.IO) {
            data = getShopItemUseCase.getShopItem(shopItem)
        }
        return data
    }

}
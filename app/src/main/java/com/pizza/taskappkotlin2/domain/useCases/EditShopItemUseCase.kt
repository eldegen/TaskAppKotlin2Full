package com.pizza.taskappkotlin2.domain.useCases

import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {

    suspend fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }

}
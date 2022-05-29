package com.pizza.taskappkotlin2.domain.useCases

import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }

}
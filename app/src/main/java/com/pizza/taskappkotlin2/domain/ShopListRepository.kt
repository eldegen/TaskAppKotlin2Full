package com.pizza.taskappkotlin2.domain

import androidx.lifecycle.LiveData
import com.pizza.taskappkotlin2.domain.models.ShopItem

interface ShopListRepository {

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

    suspend fun getShopItem(shopItemId: Int): ShopItem

    // TODO: Может быть изменен
    fun getShopList(): LiveData<List<ShopItem>>

}
package com.pizza.taskappkotlin2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.pizza.taskappkotlin2.App
import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.domain.ShopListRepository
import com.pizza.taskappkotlin2.utils.ShopListMapper

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList =
        sortedSetOf<ShopItem>({ element1, element2 -> element1.id.compareTo(element2.id) })
    private val mapper = ShopListMapper()

    override suspend fun addShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.db.shopItemDao().getAll()
    ) {
        mapper.mapListDBModelToListEntity(it)
    }

}
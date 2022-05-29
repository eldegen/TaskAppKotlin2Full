package com.pizza.taskappkotlin2.utils

import com.pizza.taskappkotlin2.data.model.ShopItemDBModel
import com.pizza.taskappkotlin2.domain.models.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDBModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem(
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enabled = shopItemDBModel.enabled
    )

    fun mapListDBModelToListEntity(shopListDBModel: List<ShopItemDBModel>) = shopListDBModel.map {
        mapDBModelToEntity(it)
    }

}
package com.pizza.taskappkotlin2.domain.models

import java.io.Serializable
import javax.inject.Inject

data class ShopItem @Inject constructor(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
): Serializable {
    companion object {
        const val UNDEFINED_ID = 0
    }
}

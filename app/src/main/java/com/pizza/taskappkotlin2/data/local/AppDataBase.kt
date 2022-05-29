package com.pizza.taskappkotlin2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pizza.taskappkotlin2.data.model.ShopItemDBModel

@Database(entities = [ShopItemDBModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun shopItemDao(): ShopItemDao
}
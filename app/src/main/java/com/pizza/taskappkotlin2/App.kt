package com.pizza.taskappkotlin2

import android.app.Application
import androidx.room.Room
import com.pizza.taskappkotlin2.data.local.AppDataBase
import com.pizza.taskappkotlin2.di.DaggerNewComponent
import com.pizza.taskappkotlin2.domain.models.ShopItem
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var shopItem: ShopItem

    init {
        DaggerNewComponent.create().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase").fallbackToDestructiveMigration().build()
    }


    companion object {
        lateinit var db: AppDataBase
    }

}
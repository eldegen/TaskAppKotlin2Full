package com.pizza.taskappkotlin2.di

import android.app.Application
import dagger.Component
import com.pizza.taskappkotlin2.domain.models.NameModule

@Component(modules = [NameModule::class])
interface NewComponent {
    fun inject(app: Application)
}
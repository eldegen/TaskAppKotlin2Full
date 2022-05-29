package com.pizza.taskappkotlin2.domain.models

import dagger.Module
import dagger.Provides

@Module
class NameModule {

    @Provides
    fun provideName(name: String): String {
        return name
    }

}
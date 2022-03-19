package com.bimabagaskhoro.assigment1.di

import com.bimabagaskhoro.assigment1.domain.usecase.ItemGuestInteractor
import com.bimabagaskhoro.assigment1.domain.usecase.ItemGuestUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideItemGuestUseCase(itemGuestInteractor: ItemGuestInteractor): ItemGuestUseCase

}
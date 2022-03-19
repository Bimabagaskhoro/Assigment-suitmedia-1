package com.bimabagaskhoro.assigment1.di

import android.content.Context
import androidx.room.Room
import com.bimabagaskhoro.assigment1.data.source.local.room.ItemGuestDao
import com.bimabagaskhoro.assigment1.data.source.local.room.ItemGuestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ItemGuestDatabase =
        Room.databaseBuilder(
            context,
            ItemGuestDatabase::class.java, "item_guest.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: ItemGuestDatabase): ItemGuestDao = database.tourismDao()

}
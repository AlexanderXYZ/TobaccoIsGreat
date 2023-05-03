package com.buslaev.tobaccoisgreat.di

import android.content.Context
import androidx.room.Room
import com.buslaev.tobaccoisgreat.data.locale.TobaccoDao
import com.buslaev.tobaccoisgreat.data.locale.TobaccoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideTobaccoDatabase(@ApplicationContext applicationContext: Context): TobaccoDatabase =
        Room.databaseBuilder(
            context = applicationContext,
            TobaccoDatabase::class.java,
            "database-tobacco"
        ).build()

    @Provides
    fun provideTobaccoDao(database: TobaccoDatabase): TobaccoDao = database.tobaccoDao()
}
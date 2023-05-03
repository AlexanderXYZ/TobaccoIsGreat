package com.buslaev.tobaccoisgreat.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.buslaev.tobaccoisgreat.domain.entity.Brand
import com.buslaev.tobaccoisgreat.domain.entity.Tobacco

@Database(
    entities = [Tobacco::class, Brand::class],
    version = 1
)
abstract class TobaccoDatabase : RoomDatabase() {
    abstract fun tobaccoDao(): TobaccoDao
}
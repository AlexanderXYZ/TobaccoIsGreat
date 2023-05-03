package com.buslaev.tobaccoisgreat.data.locale

import androidx.room.Dao
import androidx.room.Query
import com.buslaev.tobaccoisgreat.domain.entity.Brand
import com.buslaev.tobaccoisgreat.domain.entity.Tobacco

@Dao
interface TobaccoDao {

    @Query("SELECT * FROM tobacco_table")
    fun selectAllTobacco(): List<Tobacco>

    @Query("SELECT * FROM brand_table")
    fun selectAllBrand(): List<Brand>

    @Query("SELECT * FROM tobacco_table WHERE category_id == :categoryId")
    fun getTobaccoByCategoryId(categoryId: Int): List<Tobacco>
}
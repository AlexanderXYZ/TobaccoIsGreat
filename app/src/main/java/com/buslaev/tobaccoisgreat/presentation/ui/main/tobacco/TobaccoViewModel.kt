package com.buslaev.tobaccoisgreat.presentation.ui.main.tobacco

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buslaev.tobaccoisgreat.data.locale.TobaccoDao
import com.buslaev.tobaccoisgreat.domain.entity.Brand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TobaccoScreenState(
    val brandList: List<Brand> = emptyList()
)

@HiltViewModel
class TobaccoViewModel @Inject constructor(
    private val tobaccoDao: TobaccoDao
) : ViewModel() {

    private var _state = MutableStateFlow(TobaccoScreenState())
    val state get() = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO) {
        val categoryList = tobaccoDao.selectAllBrand()
        _state.value = state.value.copy(brandList = categoryList)
    }
}

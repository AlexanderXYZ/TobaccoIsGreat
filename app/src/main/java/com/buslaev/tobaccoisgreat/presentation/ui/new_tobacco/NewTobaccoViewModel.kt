package com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco

import androidx.lifecycle.ViewModel
import com.buslaev.tobaccoisgreat.data.locale.TobaccoDao
import com.buslaev.tobaccoisgreat.domain.entity.Brand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class NewTobaccoState(
    val brandList: List<Brand> = emptyList()
)

@HiltViewModel
class NewTobaccoViewModel @Inject constructor(
    private val dao: TobaccoDao
) : ViewModel() {

    private var _state = MutableStateFlow(NewTobaccoState())
    val state get() = _state.asStateFlow()
}
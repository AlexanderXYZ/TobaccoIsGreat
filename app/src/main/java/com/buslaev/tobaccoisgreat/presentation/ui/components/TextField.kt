package com.buslaev.tobaccoisgreat.presentation.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TobaccoOutlinedTextField(
    value: String,
    labelText: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        label = { TobaccoText(text = labelText) },
        onValueChange = onValueChange
    )
}
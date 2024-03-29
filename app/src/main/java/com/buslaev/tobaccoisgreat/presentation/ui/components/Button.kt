package com.buslaev.tobaccoisgreat.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TobaccoDefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun TobaccoDefaultTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(text = text)
    }
}
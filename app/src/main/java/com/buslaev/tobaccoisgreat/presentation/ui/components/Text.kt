package com.buslaev.tobaccoisgreat.presentation.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TobaccoText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.White
) {
    Text(modifier = modifier, text = text, color = color)
}
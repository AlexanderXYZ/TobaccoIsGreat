package com.buslaev.tobaccoisgreat.presentation.ui.main.tobacco

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buslaev.tobaccoisgreat.domain.entity.Brand
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoText
import com.buslaev.tobaccoisgreat.presentation.ui.components.VerticalSpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TobaccoScreen(
    state: TobaccoScreenState,
    navigateToAddTobaccoScreen: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToAddTobaccoScreen) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add tobacco")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(state.brandList.size) {
                BrandTobaccoItem(brand = state.brandList[it], onClick = {})
            }
        }
    }
    Text(text = "TobaccoScreen")
}

@Composable
fun BrandTobaccoItem(modifier: Modifier = Modifier, brand: Brand, onClick: (Brand) -> Unit) {
    Column(modifier = modifier.clickable { onClick.invoke(brand) }) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Image(painter = , contentDescription = "Brand image")
            Column {
                TobaccoText(text = brand.name)
                VerticalSpacer(space = 2)
                TobaccoText(text = brand.id.toString())
            }
        }
        VerticalSpacer(space = 4)
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(MaterialTheme.colorScheme.surface)
        )
    }
}
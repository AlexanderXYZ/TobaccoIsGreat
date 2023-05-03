package com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.buslaev.tobaccoisgreat.R
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoOutlinedTextField
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoTopAppBar
import com.buslaev.tobaccoisgreat.presentation.ui.components.VerticalSpacer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTobaccoScreen(
    state: NewTobaccoState,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TobaccoTopAppBar(
                title = stringResource(id = R.string.new_tobacco_screen_title),
                onBackClick = navController::popBackStack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            var tobaccoName by remember { mutableStateOf("") }
            var tobaccoGram by remember { mutableStateOf("") }
            var dropMenuBrand by remember { mutableStateOf(false) }

            DropdownMenu(expanded = dropMenuBrand, onDismissRequest = { dropMenuBrand = false }) {
                state.brandList.forEach {
                    DropdownMenuItem(text = { Text(text = it.name) }, onClick = { /*TODO*/ })
                }
            }

            VerticalSpacer(space = 16)

            TobaccoOutlinedTextField(
                value = tobaccoName,
                labelText = stringResource(id = R.string.new_tobacco_name),
                onValueChange = { tobaccoName = it })

            VerticalSpacer(space = 8)

            TobaccoOutlinedTextField(
                value = tobaccoGram,
                labelText = stringResource(id = R.string.new_tobacco_gram),
                onValueChange = { tobaccoGram = it })
        }
    }
}
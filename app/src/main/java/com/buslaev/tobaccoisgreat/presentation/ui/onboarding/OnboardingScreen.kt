package com.buslaev.tobaccoisgreat.presentation.ui.onboarding

import android.content.res.Resources
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.buslaev.tobaccoisgreat.R
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoDefaultButton
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoDefaultTextButton
import com.buslaev.tobaccoisgreat.presentation.ui.components.VerticalSpacer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class OnboardingItemData(
    val text: String,
    val image: String
) {

    companion object {
        fun createOnboardingList(resource: Resources): List<OnboardingItemData> {
            return listOf(
                OnboardingItemData(resource.getString(R.string.onboarding_text_one), ""),
                OnboardingItemData(resource.getString(R.string.onboarding_text_two), ""),
                OnboardingItemData(resource.getString(R.string.onboarding_text_three), "")
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    startClick: () -> Unit
) {

    val pagerState = rememberPagerState()
    val resources = LocalContext.current.resources
    val pagerList by remember { mutableStateOf(OnboardingItemData.createOnboardingList(resources)) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxHeight(0.75F),
            state = pagerState,
            pageCount = pagerList.size
        ) { page ->
            OnboardingItem(data = pagerList[page])
        }

        VerticalSpacer(space = 16)

        Row {
            repeat(pagerList.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else Color.DarkGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)

                )
            }
        }

        VerticalSpacer(space = 16)

        if (pagerState.currentPage < pagerList.size - 1) {
            TobaccoDefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.button_continue),
                onClick = {
                    scope.launch(Dispatchers.Main) {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                }
            )
            TobaccoDefaultTextButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.button_skip),
                onClick = {
                    scope.launch(Dispatchers.Main) {
                        pagerState.animateScrollToPage(
                            pagerList.size - 1
                        )
                    }
                }
            )
        } else {
            TobaccoDefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.button_start),
                onClick = startClick
            )
        }
    }
}

@Composable
private fun OnboardingItem(
    data: OnboardingItemData
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 56.dp, vertical = 32.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            text = data.text,
            textAlign = TextAlign.Center
        )
    }
}
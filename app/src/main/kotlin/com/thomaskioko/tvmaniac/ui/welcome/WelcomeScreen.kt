package com.thomaskioko.tvmaniac.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.thomaskioko.tvmaniac.compose.components.GradientText
import com.thomaskioko.tvmaniac.compose.matchParent
import com.thomaskioko.tvmaniac.navigation.NavigationScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .matchParent()
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GradientText(
            text = mutableStateOf("Tv Maniac").value
        )
    }

    LaunchedEffect(Unit) {

        viewModel.viewModelScope.launch {
            delay(1000)
            navController.navigate(NavigationScreen.DiscoverNavScreen.route)
        }
    }

}
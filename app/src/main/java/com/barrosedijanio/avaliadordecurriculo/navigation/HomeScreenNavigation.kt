package com.barrosedijanio.avaliadordecurriculo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.barrosedijanio.avaliadordecurriculo.ui.screens.HomeScreen


fun NavGraphBuilder.homeScreen(
    navigateToReviewScreen: (target: String, experience: String, curriculum: String) -> Unit
) {
    composable(Routes.HOME_SCREEN_ROUTE) {
        HomeScreen(
        ) { target, experience, curriculum ->
            navigateToReviewScreen(target, experience, curriculum)
        }
    }
}
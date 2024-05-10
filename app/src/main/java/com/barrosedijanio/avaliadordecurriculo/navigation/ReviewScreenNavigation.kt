package com.barrosedijanio.avaliadordecurriculo.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.barrosedijanio.avaliadordecurriculo.models.GeminiRequest
import com.barrosedijanio.avaliadordecurriculo.ui.screens.ReviewScreen
import com.barrosedijanio.avaliadordecurriculo.viewmodels.ViewModel
import org.koin.androidx.compose.koinViewModel


@SuppressLint("StateFlowValueCalledInComposition")
fun NavGraphBuilder.reviewScreen(
    navigateToHome: () -> Unit
) {
    composable(
        Routes.REVIEW_SCREEN_ROUTE,
    ) {
        val target = it.arguments?.getString("target")
        val experience = it.arguments?.getString("experience")
        val curriculum = it.arguments?.getString("curriculum")

        val viewModel: ViewModel = koinViewModel()
        viewModel.generationSetup(GeminiRequest(target!!, experience!!, curriculum!!))
        val response  by viewModel.geminiResponse.collectAsState()

        ReviewScreen(
            response,
            navigateToHome
        )
    }
}
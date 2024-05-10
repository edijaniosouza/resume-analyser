package com.barrosedijanio.avaliadordecurriculo.models

sealed class GeminiResult {
    data class Success(val message: GeminiResponse) : GeminiResult()
    data class Error(val message: String): GeminiResult()
    data object DefaultError: GeminiResult()
    data object Loading: GeminiResult()
    data object Empty: GeminiResult()
}
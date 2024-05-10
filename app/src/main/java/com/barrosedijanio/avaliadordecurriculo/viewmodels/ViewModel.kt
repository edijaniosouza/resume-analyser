package com.barrosedijanio.avaliadordecurriculo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barrosedijanio.avaliadordecurriculo.ia.GeminiConnection
import com.barrosedijanio.avaliadordecurriculo.models.GeminiRequest
import com.barrosedijanio.avaliadordecurriculo.models.GeminiResponse
import com.barrosedijanio.avaliadordecurriculo.models.GeminiResult
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ViewModel(
    private val geminiConnection: GeminiConnection
) : ViewModel() {

    private val _geminiResponse = MutableStateFlow<GeminiResult>(GeminiResult.Empty)
    val geminiResponse = _geminiResponse.asStateFlow()

    @OptIn(ExperimentalSerializationApi::class)
    fun generationSetup(geminiRequest: GeminiRequest) {
        viewModelScope.launch {
            _geminiResponse.value = GeminiResult.Loading


            try {
                val response = geminiConnection.generation(
                    content("user") {
                        text("vaga desejada: ${geminiRequest.target}")
                        text("nivel de experiencia: ${geminiRequest.experience}")
                        text("---Curriculo abaixo---")
                        text(geminiRequest.curriculum)
                    }
                )

                val format = Json {
                    ignoreUnknownKeys = true
                    allowTrailingComma = true
                }

                if (response != null) {
                    val responseConverted: GeminiResponse = format.decodeFromString(response)
                    _geminiResponse.value = GeminiResult.Success(responseConverted)

                }

            } catch (e: Exception) {
                Log.e("gemini", "erro: ${e.message}")
                _geminiResponse.value = e.message?.let { GeminiResult.Error(it) }!!
            }

        }

    }
}
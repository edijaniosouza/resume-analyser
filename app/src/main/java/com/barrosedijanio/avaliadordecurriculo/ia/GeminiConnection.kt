package com.barrosedijanio.avaliadordecurriculo.ia

import com.barrosedijanio.avaliadordecurriculo.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.generationConfig


class GeminiConnection {
    private val apiKey = BuildConfig.API_KEY
    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.0-pro",
        apiKey = apiKey,
        generationConfig = generationConfig {
            temperature = 0f
            topK = 0
            topP = 1f
            maxOutputTokens = 2048
            candidateCount = 1
        },
        safetySettings = listOf(
            SafetySetting(HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE),
        ),
    )

    suspend fun generation(content: Content): String? {
        return try {
            val chat = generativeModel.startChat( listOf(inputHistory, outputHistory, input2, output2))
            chat.sendMessage(content).text
        } catch (e: Exception) {
            e.message
        }
    }
}

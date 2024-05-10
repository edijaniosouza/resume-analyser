package com.barrosedijanio.avaliadordecurriculo.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeminiResponse(
    @SerialName("pontos fortes") val pontosFortes: List<String>,
    @SerialName("pontos a melhorar") val pontosAMelhorar: List<String>,
    val sugestoes: List<String>,
    val conclusao: List<String>,
)

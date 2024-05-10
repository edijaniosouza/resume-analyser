package com.barrosedijanio.avaliadordecurriculo.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barrosedijanio.avaliadordecurriculo.R
import com.barrosedijanio.avaliadordecurriculo.models.GeminiResponse
import com.barrosedijanio.avaliadordecurriculo.models.GeminiResult

@Composable
fun ReviewScreen(
    geminiResult: GeminiResult,
    navigateToHome: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1D3A84))
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var response by remember { mutableStateOf<GeminiResponse?>(null) }
        Log.i("ReviewScreen", "ReviewScreen: $response")
        var loading by remember { mutableStateOf(false) }
        var error by remember { mutableStateOf("") }

        Text(
            "Avaliação",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (response == null && error.isEmpty()) {
                CircularProgressIndicator()
            }
            if(error.isNotEmpty() && response == null) {
                Text(error, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }

            response?.let { ReviewPoints("Pontos fortes: ", Color(0x4D000000), it.pontosFortes) }
            response?.let {
                ReviewPoints(
                    "Pontos a melhorar: ",
                    Color(0xFF7C0000),
                    it.pontosAMelhorar
                )
            }
            response?.let { ReviewPoints("Sugestões: ", Color(0x4D0B4905), it.sugestoes) }
            response?.let { ReviewPoints("Conclusão: ", Color(0x33FFFFFF), it.conclusao) }
        }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    "Isso foi útil?",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
                var like by remember { mutableStateOf(false) }
                var dislike by remember { mutableStateOf(false) }
                var likeColor = Color(0xFF138800)
                var dislikeColor = Color(0xFF138800)
                IconButton(onClick = { like = !like }) {

                    if (like) {
                        likeColor = Color(0xFF24FF00)
                        dislikeColor = Color(0xFF960000)
                    } else {
                        likeColor = Color(0xFF138800)
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_like_24),
                        tint = likeColor,
                        contentDescription = "like"
                    )
                }
                IconButton(onClick = { dislike = !dislike }) {
                    if (dislike) {
                        dislikeColor = Color(0xFFFF0000)
                        likeColor = Color(0xFF138800)
                    } else {
                        dislikeColor = Color(0xFF960000)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_dislike_24),
                        tint = dislikeColor,
                        contentDescription = "dislike"
                    )
                }
            }

            IconButton(onClick = navigateToHome) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home page",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
            }
        }

        LaunchedEffect(key1 = geminiResult) {
            when (geminiResult) {
                is GeminiResult.Success -> {
                    response = geminiResult.message
                    loading = false
                    error = ""
                }

                is GeminiResult.Error -> {
                    error = geminiResult.message
                    loading = false
                }

                is GeminiResult.Loading -> {
                    error = ""
                    loading = true
                }

                else -> Unit
            }
        }
    }
}

@Composable
fun ReviewPoints(topic: String, topicColor: Color, points: List<String>) {
    Column(
        Modifier
            .padding(15.dp)
            .background(topicColor, shape = ShapeDefaults.Medium)
            .padding(7.dp)
    ) {
        Text(topic, color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Divider(Modifier.padding(5.dp))

        points.map {
            Text(
                it,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(7.dp),
                textAlign = TextAlign.Start
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun ReviewScreenPreview() {
    ReviewScreen(geminiResult = GeminiResult.Empty, {})
}
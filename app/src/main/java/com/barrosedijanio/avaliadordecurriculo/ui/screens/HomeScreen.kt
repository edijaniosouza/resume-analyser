package com.barrosedijanio.avaliadordecurriculo.ui.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barrosedijanio.avaliadordecurriculo.R
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader
import com.tom_roush.pdfbox.pdmodel.PDDocument
import com.tom_roush.pdfbox.text.PDFTextStripper
import java.io.IOException
import java.io.InputStream


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    generateResponse: (target: String, experience: String, curriculum: String) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1D3A84)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var target by remember { mutableStateOf("") }
        val context = LocalContext.current
        var content by remember { mutableStateOf("") }

        val launcher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.data?.let { uri ->
                        try {
                            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                                val pdfConvertedToString = convertPdfToString(inputStream, context)
                                content = pdfConvertedToString
                            }
                        } catch (e: IOException) {
                            e.message?.let { print(e) }
                        }
                    }
                }
            }

        Text(
            modifier = Modifier.padding(vertical = 38.dp),
            text = "Insira seu curriculo",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        IconButton(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color(0xFFD9D9D9), shape = CircleShape),
            enabled = content.isEmpty(),
            onClick = {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "application/pdf"
                launcher.launch(intent)
            }) {
            val iconColor = Color(
                0xB3000000
            )
            val iconModifier = Modifier.size(81.dp, 103.dp)
            if (content.isNotEmpty()) {
                Icon(
                    modifier = iconModifier,
                    painter = painterResource(id = R.drawable.baseline_file_download_done_24),
                    contentDescription = "File uploaded",
                    tint = iconColor
                )
            } else {
                Icon(
                    modifier = iconModifier,
                    painter = painterResource(id = R.drawable.baseline_file_open_24),
                    contentDescription = "File upload",
                    tint = iconColor
                )
            }
        }

        Column {
            Text(
                modifier = Modifier.padding(top = 56.dp),
                text = "Objetivo da vaga:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            OutlinedTextField(
                colors = TextFieldDefaults.colors(Color(0x4DD9D9D9)),
                textStyle = TextStyle(color = Color.Black),
                maxLines = 1,
                placeholder = { Text("Adicione seu objetivo") },
                value = target,
                onValueChange = { newText -> target = newText },
            )
        }
        val options = listOf(
            "",
            "Estagiário",
            "Aprendiz",
            "Assistente",
            "Analista",
            "Júnior",
            "Pleno",
            "Senior",
            "Coordenador",
            "Especialista",
            "Supervisor",
            "Gerente",
            "Diretor"
        )
        var experience by remember { mutableStateOf(options[0]) }
        var expanded by remember { mutableStateOf(false) }
        Column {
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Nivel de experiência:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it })
            {

                OutlinedTextField(
                    modifier = Modifier.menuAnchor(),
                    value = experience, onValueChange = {},
                    readOnly = true,
                    singleLine = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    placeholder = { Text("Adicione sua experiência") },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    options.forEach { options ->
                        DropdownMenuItem(
                            text = { Text(text = options) },
                            onClick = {
                                experience = options
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }

        TextButton(
            onClick = {
                if (target.isEmpty() || experience.isEmpty() || content.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Por favor, insira todas as informações",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    generateResponse(target, experience, content)
                }
            },
            shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(Color.White),
            elevation = ButtonDefaults.elevatedButtonElevation(),
            modifier = Modifier
                .size(209.dp, 72.dp)
                .padding(top = 20.dp)
        ) {
            Text(
                "Avaliar",
                color = Color(0xFF2A4FAD),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

private fun convertPdfToString(inputStream: InputStream, context: Context): String {

    PDFBoxResourceLoader.init(context)
    val document = PDDocument.load(inputStream)
    val stripper = PDFTextStripper()
    val text = stripper.getText(document)
    document.close()
    return text
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(generateResponse = { _, _, _ ->  })
}
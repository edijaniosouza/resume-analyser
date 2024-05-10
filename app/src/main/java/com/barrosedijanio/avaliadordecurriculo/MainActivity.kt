package com.barrosedijanio.avaliadordecurriculo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.barrosedijanio.avaliadordecurriculo.navigation.Routes
import com.barrosedijanio.avaliadordecurriculo.navigation.homeScreen
import com.barrosedijanio.avaliadordecurriculo.navigation.reviewScreen
import com.barrosedijanio.avaliadordecurriculo.ui.theme.AvaliadorDeCurriculoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvaliadorDeCurriculoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN_ROUTE) {
        homeScreen { target, experience, curriculum ->
            val curriculumChanged = curriculum.replace("/", "-")
            Log.i("gemini", "Navigation: $curriculumChanged")
            navController.navigate("review_screen/$curriculumChanged/$target/$experience")
        }
        reviewScreen(){
            navController.popBackStack()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AvaliadorDeCurriculoTheme {
    }
}
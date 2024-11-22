package space.pablorjd.jetpackcomposecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun OneScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Pantalla One", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("screen2") })
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Pantalla Two", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("screen3") })
    }
}

@Composable
fun TreeeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("screen1") })
    }
}
package space.pablorjd.jetpackcomposecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BasicSlider() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPositions by remember { mutableStateOf(0f) }
        Slider(value = sliderPositions, onValueChange = { sliderPositions = it })

        Text(text = sliderPositions.toString())
    }


}

@Composable
fun AdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPositions by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPositions,
            onValueChange = { sliderPositions = it },
            onValueChangeFinished = { completeValue = sliderPositions.toString() },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = completeValue)
    }
}

@Preview(showBackground = true)
@Composable
fun BasicSliderPreview() {
    AdvanceSlider()
}

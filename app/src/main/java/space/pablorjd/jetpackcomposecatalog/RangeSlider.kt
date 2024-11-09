package space.pablorjd.jetpackcomposecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyRangeSlider() {
    Column( horizontalAlignment = Alignment.CenterHorizontally ) {
        var currenRangeValue by remember { mutableStateOf(0f..10f) }
        RangeSlider(
            value = currenRangeValue,
            onValueChange = { currenRangeValue = it },
            valueRange = 0f..40f,
            steps = 38

        )

        Text( text = "Valor inferior ${currenRangeValue.start}" )
        Text( text = "Valor Superior ${currenRangeValue.endInclusive}" )
    }

}

@Preview(showBackground = true)
@Composable
fun MyRangeSliderPreview() {
    MyRangeSlider()
}

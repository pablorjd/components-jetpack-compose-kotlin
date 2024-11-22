package space.pablorjd.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import space.pablorjd.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "screen1") {
                        composable(route = "screen1") {
                            OneScreen(navController)
                        }
                        composable(route = "screen2") {
                            SecondScreen(navController)
                        }
                        composable(route = "screen3") {
                            TreeeScreen(navController)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(title = it,
            selected = status,
            onCheckeChange = { myNewStatus -> status = myNewStatus })
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BasicSlider()
        }

    }
}


@Composable
fun MySlider() {

}

@Composable
fun MyDropDownMenu() {
    var selectedText by rememberSaveable {
        mutableStateOf("")
    }

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val desserts = listOf<String>("Helado", "Fruta", "Cafe", "Carne", "Chilaquiles")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@ExperimentalMaterial3Api
@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge {
                val badgeNumber = "8"
                Text(
                    badgeNumber
                )
            }
        },
    ) {
        Icon(
            Icons.Filled.Star, contentDescription = "Favorite"
        )
    }
}

@Composable
fun MyCard() {
    val elevation = 12.dp
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(elevation),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.Red
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Ejemplo1")
            Text(text = "Ejemplo1")
            Text(text = "Ejemplo1")
            Text(text = "Ejemplo1")
        }
    }
}

@Composable
fun MyRadioButtom() {
    Row(Modifier.fillMaxWidth()) {

        RadioButton(
            selected = false,
            onClick = { /*TODO*/ },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text(text = "Ejemplo 1")
    }

}

@Composable
fun MyRadioButtonList(status: String, onItemSelected: (String) -> Unit) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.padding(6.dp)) {
            RadioButton(selected = status == "Pablo", onClick = { onItemSelected("Pablo") })
            Text(text = "Pablo", modifier = Modifier.padding(12.dp))
        }
        Row(modifier = Modifier.padding(6.dp)) {
            RadioButton(selected = status == "Litzi", onClick = { onItemSelected("Litzi") })
            Text(text = "Litzi", modifier = Modifier.padding(12.dp))
        }
        Row(modifier = Modifier.padding(6.dp)) {
            RadioButton(selected = status == "Florencia", onClick = { onItemSelected("Florencia") })
            Text(text = "Florencia", modifier = Modifier.padding(12.dp))
        }
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = state, onClick = {
        state = when (state) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })

}

// state hoisting trabajando con estados mas complejos
@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckeChange(!checkInfo.selected) })
        Spacer(Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(
        modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(Modifier.width(8.dp))
        //Text(text = "Ejemplo 1", Modifier.padding( top = 12.dp)) forma 1
        Text(text = "Ejemplo 2")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red, uncheckedColor = Color.Green
        )
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan
        )
    )
}

@Composable
fun MyProgressBarAdavance() {

    var percentToProgress by rememberSaveable {
        mutableStateOf(0.1f)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),

        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = percentToProgress)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { percentToProgress += 0.1f }) {
                Text(text = "Incrementar +")
            }
            Button(onClick = { percentToProgress -= 0.1f }) {
                Text(text = "Decrementar -")
            }
        }
    }

}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Blue, strokeWidth = 4.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 34.dp),
                color = Color.Green,
                trackColor = Color.Blue
            )
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "ChangeState")
        }

    }
}

@Composable
fun MyIcon() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 8.dp)
    ) {
        Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = "Icono", tint = Color.Red)
    }

}

@Composable
fun MyImageAdavance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(RoundedCornerShape(25f))
            .border(5.dp, Color.Red, CircleShape)

    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButton() {
    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enable = false }, enabled = enable, colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
            ), border = BorderStroke(3.dp, Color.Green)
        ) {
            Text(text = "Click")
        }

        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 10.dp)) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Soy un textButton")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText: String by remember { mutableStateOf("Pablo") }
    OutlinedTextField(value = myText,
        onValueChange = { myText = it },
        Modifier.padding(16.dp),
        label = {
            Text(
                text = "Holita",
            )
        })
}

@Composable
fun MyTextFildsAdvance() {
    var myText: String by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyTextFilds(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange(it) })
}

// Componente de Texto, aplicando estilos
@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text("Esto es un ejemplo")
        Text("Esto es un ejemplo", color = Color.Blue)
        Text("Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text("Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text("Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough, TextDecoration.Underline
                    )
                )
            )
        )
        Text("Esto es un ejemplo", fontSize = 35.sp)
    }
}
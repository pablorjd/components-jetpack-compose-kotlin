package space.pablorjd.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import space.pablorjd.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        /**MyTextFildsAdvance()
                        Spacer(modifier = Modifier.height(20.dp))
                        MyTextFieldOutlined()**/

                        // var myText: String by remember { mutableStateOf("Pablo") }
                        // MyTextFilds(myText, { myText = it })
                        //MyButton()
                        //MyProgressBar()
                        MyProgressBarAdavance()
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogTheme {

        //MyButton()
        //MyImageAdavance()

        MyIcon()
        MyProgressBarAdavance()
    }
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

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = percentToProgress)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { percentToProgress+=0.1f }) {
                Text(text = "Incrementar +")
            }
            Button(onClick = { percentToProgress-=0.1f }) {
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
            onClick = { enable = false },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
            ),
            border = BorderStroke(3.dp, Color.Green)
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
    OutlinedTextField(
        value = myText,
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
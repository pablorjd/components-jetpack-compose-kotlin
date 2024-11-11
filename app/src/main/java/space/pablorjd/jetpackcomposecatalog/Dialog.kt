package space.pablorjd.jetpackcomposecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(Modifier.fillMaxWidth().background(Color.White).padding(24.dp)) {
                MyTitleDIalog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider( Modifier.fillMaxWidth(), color = Color.LightGray )

                var selected by remember {
                    mutableStateOf("")
                }

                MyRadioButtonList(selected, {selected = it})

                Divider( Modifier.fillMaxWidth(), color = Color.LightGray )

                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {}) {
                        Text("Cancel")
                    }

                    TextButton(onClick = {}) {
                        Text("Ok")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            )
            {
                MyTitleDIalog("Set backup account")
                AccountItem("ejem@gmail.com",R.drawable.img)
                AccountItem("ejem@gmail.com",R.drawable.imgm)
                AccountItem("ejem@gmail.com",R.drawable.foto1)
                AccountItem("Add account",R.drawable.ic_add)
            }

        }
    }

}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun MyTitleDIalog(text: String, modifier: Modifier = Modifier.padding(bottom = 15.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean, onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = {
                onDismiss()
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    "Esto es un ejemplo",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
fun MyAlertDialog(show: Boolean, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    if (show) {
        AlertDialog(
            title = {
                Text(text = "Titulo del Dialog")
            },
            text = {
                Text(text = "Cuerpo del mensaje")
            },
            onDismissRequest = {
                onDismiss()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text("Dismiss")
                }
            },

            )
    }
}


@Preview(showBackground = true)
@Composable
fun MyBasicDialogPreview() {
    MyConfirmationDialog(true, {})
}

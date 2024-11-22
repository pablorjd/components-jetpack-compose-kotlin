package space.pablorjd.jetpackcomposecatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                content = { MyDrawer { scope.launch { drawerState.close() } } }
            )
        },
        gesturesEnabled = true,
        content = {
            Scaffold(
                topBar = {
                    MyTopAppBar(
                        drawerState,
                        scope
                    ) {
                        scope.launch {
                            snackbarHostState.showSnackbar("Haz pulsado un icono ${it}")
                        }
                    }
                },
                snackbarHost = { SnackbarHost(snackbarHostState) },
                bottomBar = { MyBottomBar() },
                floatingActionButton = { MyFloatingActionButton() },
                floatingActionButtonPosition = FabPosition.End,

                ) {}
        })
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Tercera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Cuarta opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
    }
}


@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        modifier = Modifier
            .offset(y = 0.dp)
            .size(80.dp)
            .clip(RoundedCornerShape(corner = CornerSize(50.dp))),

        onClick = {},
        content = {
            Icon(imageVector = Icons.Filled.Add, "plus icon", modifier = Modifier.size(60.dp))
        })

}

@Composable
fun MyBottomBar() {
    var index by remember { mutableStateOf(0) }
    NavigationBar(tonalElevation = 8.dp) {
        NavigationBarItem(
            label = { Text("Lock") },
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Filled.Lock, "test") }
        )
        NavigationBarItem(
            label = { Text("Favorite") },
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Filled.Favorite, "test") }
        )
        NavigationBarItem(
            label = { Text("Person") },
            selected = index == 2,
            onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Filled.Person, "test") }
        )
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onClickIcon: (String) -> Unit,

    ) {
    TopAppBar(
        title = { Text(text = "My First App") },
        //colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Gray),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, "backIcons")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, "search")
            }
        })
}


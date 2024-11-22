package space.pablorjd.jetpackcomposecatalog.model

sealed class Routes(val route:String) {
    object Pantalla1: Routes("pantall1")
    object Pantalla2: Routes("pantall2")
    object Pantalla3: Routes("pantall3")
}
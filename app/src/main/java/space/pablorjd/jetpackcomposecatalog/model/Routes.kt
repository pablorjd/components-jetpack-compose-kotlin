package space.pablorjd.jetpackcomposecatalog.model

sealed class Routes(val route:String) {
    object Pantalla1: Routes("pantall1")
    object Pantalla2: Routes("pantall2")
    object Pantalla3: Routes("pantall3")
    object Pantalla4: Routes("pantall4/{age}"){
        fun createRoute(age:Int) = "pantall4/$age"
    }
    object Pantalla5: Routes("pantalla5/{name}"){
        fun createRoute(name:String) = "pantalla5/$name"
    }
}
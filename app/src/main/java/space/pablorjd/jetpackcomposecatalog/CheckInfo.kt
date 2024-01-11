package space.pablorjd.jetpackcomposecatalog

data class CheckInfo(val title:String, var selected:Boolean = false, var onCheckeChange:(Boolean)->Unit)

fun isLetter(symbol: Char): Boolean {
    return symbol in 'a'..'z' || symbol in 'A'..'Z'
}

fun main(args: Array<String>) {
    val arr = arrayOf('a', 'A', '1', '2', '&', '?', 'g', 'H')
    var res = ""
    arr.forEach { element ->
        res = if (!isLetter(element))
            " not"
        else
            ""
        println("\"$element\" is$res a letter!")
    }
}
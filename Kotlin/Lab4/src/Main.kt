fun getLengthString(str: String?) = str?.length ?: -1

fun main(args: Array<String>) {
    val res = getLengthString(null)
    if (res >= 0) {
        println("String line = $res")
    } else {
        println("String is null!")
    }
}
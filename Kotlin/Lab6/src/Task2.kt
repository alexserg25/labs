fun main() {
    val sortArray : IntArray = intArrayOf(5, -15, 100, -55, 20, -5, -80, 45, 25, -10)
    sortArray.sort()
    println("Sorted array view horizontal : ${sortArray.contentToString()}")
    println("Sorted array view vertical :")
    sortArray.forEach { element ->
        println(element)
    }
}
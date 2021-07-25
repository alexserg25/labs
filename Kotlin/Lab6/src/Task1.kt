import java.util.*

fun main() {
    val createArray = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)
    print("Input length of array : ")
    val lenArray = scanner.nextInt()
    for (elementNum in 0..lenArray) {
        print("Input element num $elementNum: ")
        createArray.add(scanner.nextInt())
    }

    createArray.forEach { element ->
        println(element)
    }
}
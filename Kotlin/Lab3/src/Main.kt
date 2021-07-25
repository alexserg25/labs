import java.util.*

fun getName() {
    val scanner = Scanner(System.`in`)
    print("Input name: ")
    val name = scanner.nextLine()
    print("Input age: ")
    val age = scanner.nextInt()
    println("Привет, $name! Вам $age.")
}

fun compareNumber(a: Int, b: Int): Char {
    var res: Char
    res = when {
        a > b -> '>'
        a < b -> '<'
        else -> '='
    }
    return res
}

fun getEven(a: Int, b: Int): Int {
    return if ((a % 2) == 0) a
    else if ((b % 2) == 0) b
    else 0
}
// 4
fun getWeek(week: Int): String {
    return when(week) {
        1 -> "Понедельник"
        2 -> "Вторник"
        3 -> "Среда"
        4 -> "Четверг"
        5 -> "Пятница"
        6 -> "Суббота"
        7 -> "Воскресение"
        else -> "День недели задан не верно"
    }
}
// 5
fun guessNumber() {
    val scanner = Scanner(System.`in`)
    var number: Int;
    val hideNumber = 3

    while (true) {
        print("Input number (1..9): ")
        number = scanner.nextInt()
        if (hideNumber == number) {
            print("Your win! Hidden number $hideNumber.")
            return
        }
    }
}

fun main(args: Array<String>) {
    // 1
    getName()
    // 2
    var a = 10
    var b = 20
    println("a" + compareNumber(a, b) + "b")
    // 3
    a = 11
    b = 12
    println("Even number = " + getEven(a, b))
    // 4
    val scanner = Scanner(System.`in`)
    print("Input week number: ")
    val weekNumber = scanner.nextInt()
    println(getWeek(weekNumber))
    // 5
    guessNumber()
}
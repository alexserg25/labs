// Ф-я с телом выражение, тип возвращаемого значения задан
private fun multiplay2(a: Int, b: Int, c: Int): Int = a * b * c

// Ф-я с телом выражение, тип возвращаемого значения не задан
private fun multiplay1(a: Int, b: Int, c: Int) = a * b * c

// Ф-я с телом блок
private fun multiplay3(a: Int, b: Int, c: Int): Int {
    return a * b * c
}

fun main(args: Array<String>) {
    // Используем механизм "Выведения тип" (Тип переменной не задается явно)
//    val a = 5;
//    val b = 7
//    var c = 1
//    println(multiplay1(a, b, c))
//    c = 2
//    println(multiplay2(a, b, c))
//    c = 3
//    println(multiplay3(a, b, c))

    var num = 9
    num++
    num += 6
    --num
    println(num)
}
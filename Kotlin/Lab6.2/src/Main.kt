/*
1. Напишите функцию с именем mult(), которая будет принимать три числа и возвращать произведение этих чисел.
2. Найти сумму чисел
   Напишите функцию с именем sum(), которая будет принимать три числа и возвращать true, если сумма первых двух чисел
   равно третьему числу. В противном случае возвращается false.
3. Найти площадь периметра
   Создать лямбда-выражения и сохранить их в переменные, а затем вызвать их:
   Принимает две стороны прямоугольника в качестве параметра и возвращает площадь периметра.
4. Ключевое слово it
   Функция в качестве параметра принимает имя, выводит на экран строку: “Привет, [имя]!” и ничего не возвращает.
 */

fun main(args: Array<String>) {
    println("Task 1")
    val mult: (Int, Int, Int) -> Int = { x, y, z -> x * y * z }
    println(mult(1, 2, 3))

    fun multFun(a: Int, b: Int, c: Int) = a * b * c
    println(multFun(2, 3, 4))

    println("\nTask 2")
    val sum: (Int, Int, Int) -> Boolean = { x, y, z -> x * y == z }
    println(sum(2, 3, 6))
    println("${sum(2, 3, 5)}\n")

    fun sumFun(a: Int, b: Int, c: Int): Boolean = a * b == c
    println(sumFun(2, 3, 6))
    println(sumFun(2, 3, 5))

    println("\nTask 3")
    val P: (Int, Int) -> Int = { a, b -> 2 * (a + b) }
    println("P = ${P(2, 4)}")

    println("\nTask 4")
    val hello: (String) -> Unit = { println("Hello, $it!") }
    hello("Petya")

    fun helloFun(name: String): Unit = println("Hello, $name!")
    helloFun("Vasya")
}

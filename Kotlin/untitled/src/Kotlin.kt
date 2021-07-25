private fun printSum(vararg nums: Int) {
    var sum = 0
    for (num in nums) sum += num
    println("Count numbers = ${nums.size}, sum = $sum")
}

fun main(args: Array<String>) {
    printSum(1, 2, 3, 4, 5, 6, 7)
}
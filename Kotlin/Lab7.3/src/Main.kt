fun main() {
    val izhavia = Airplane("IzhAvia", 1916, 55)
    println(izhavia.getName())

    val airbus = Airbus(11)
    println(airbus.toString())

    val boeing = Boeing(true, 200)
    println(boeing.toString())

    val arrayAirplane: Array<Airplane> = arrayOf(Airbus(11), Boeing(true, 200))
    for (airplane in arrayAirplane) {
        println(airplane.getName())
        println(airplane.toString())
    }
}
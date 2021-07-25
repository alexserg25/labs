fun main(args: Array<String>) {
    println("Task 1:")
    val boing = Aircraft(5, 2010)
    println("Number seats: ${boing.numberSeats}, year = ${boing.year}")

    val aircraft: Aircraft = Aircraft(108, 2010, "superjet-100")
    println("Number seats: ${aircraft.numberSeats}, year = ${aircraft.year}, model: ${aircraft.model}")

    println("\nTask 2:")
    val moto = Car("motorbike", "suzuki", 2010)
    moto.printInformation()
    val bus = Car("bus", "gaz", 1995)
    bus.printInformation()

}

fun Car.printInformation(): Unit = println("Type: $type, brand: $brand, year: $year")
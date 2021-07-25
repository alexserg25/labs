class Car(type: String, brand: String, year: Int) {
    val type: String
    val brand: String
    var year: Int = 1806
    set(value) {
        if (value > 1806) field = value
    }

    init {
        this.type = type
        this.brand = brand
        this.year = year
    }
}
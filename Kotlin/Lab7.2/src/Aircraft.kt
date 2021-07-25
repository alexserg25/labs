class Aircraft(numberSeats: Int, year: Int) {
    var numberSeats: Int = 0
        set(value) {
            if (value > 0)
                field = value
        }
    val year: Int
    var model: String? = null
        get() = if (field == null) "" else field

    init {
        this.numberSeats = numberSeats
        this.year = year
    }

    constructor(numberSeats: Int, year: Int, model: String) : this(numberSeats, year) {
        this.model = model
    }
}
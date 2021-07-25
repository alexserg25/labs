open class Airplane(nameCompany: String, year: Int, countModels: Int) {

    val nameCompany: String
    var year: Int = 1884
        set(value) {
            if (value > 1884) field = value
        }
    var countModels: Int = 0
        set(value) {
            if (value > 0) field = value
        }

    init {
        this.nameCompany = nameCompany
        this.year = year
        this.countModels = countModels
    }

    fun getName() = "Company: $nameCompany"
}


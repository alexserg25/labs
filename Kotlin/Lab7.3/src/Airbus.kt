class Airbus(countModels: Int) : Airplane("Airbus", 1970, countModels) {
    override fun toString() = "Company name: $nameCompany, Year foundation: $year, count of models: $countModels"
}
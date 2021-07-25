class Boeing(val isCompetitor: Boolean, countModels: Int) : Airplane("Boeing", 1916, countModels) {

    override fun toString() =
        "Company name: $nameCompany, " +
                "Year foundation: $year, " +
                "count of models: $countModels, " +
                "is competitor: ${if (isCompetitor) "Yes" else "No"}"

}
open class Samsung(val model: String) {

    open fun getInfo(): String = "$model model"

}

open class Galaxy(model: String, val id: Int) : Samsung(model) {

    override fun getInfo(): String = "$id id"

}
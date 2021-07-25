interface Program {

    var number: Int

    fun change(value: String): Boolean

    fun print(text: Any): Boolean {

        println("Result: $text")

        return if(text == null) false else true

    }

}
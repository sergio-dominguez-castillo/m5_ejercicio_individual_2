package cl.bootcamp.ejercicioindividual2

fun calculatePriceTicket(weekDay: String, age: Int): Int {
    if (age < 0 || age > 100) {
        return -1 // error
    }

    val priceBase: Int
    when (age) {
        in 0..3 -> priceBase = 0
        in 4..15 -> priceBase = 15000
        in 16..60 -> priceBase = 30000
        else -> priceBase = 20000
    }

    val discount =
        if (age in 16..60
            && weekDay.lowercase() in listOf("lunes", "martes"))
            5000
        else 0

    return priceBase - discount
}

fun main() {
    println("===========================================")
    println("Precio de Entrada al Parque de Diversiones.")
    println("===========================================")

    println("Ingresa el dia de la semana (lunes, martes .. domingo):")
    var weekDay = readln()

    println("Ingresa la Edad : ")
    var age = readln().toInt()



    val price = calculatePriceTicket(weekDay, age)

    if (price == -1) {
        println("Edad ingresada no válida. Debe estar entre 0 y 100 años.")
    } else {
        println("El precio de la entrada es: $price CLP")
    }

}


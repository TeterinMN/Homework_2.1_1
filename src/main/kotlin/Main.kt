const val maestro = "Maestro"
const val master = "MasterCard"
const val visa = "VISA"
const val mir = "Мир"
const val vk = "VK Pay"
const val maxMaestro = 75000_00
const val fixMaestro = 20_00
const val percentMaestro = 0.06
const val fixVisa = 35_00
const val percentVisa = 0.0075
const val percentVk = 0

fun main() {
    visualPrint(type = maestro, transfer = 100_00)
    visualPrint(maestro, 400_00, 100_00)
    visualPrint(maestro, 100_000_00, 50_00)
    visualPrint(master, 0, 100_00)
    visualPrint(mir, 100_000_00, 5000_00)
    visualPrint(vk, 100_000_00, 5000_00)
    visualPrint(previousBuy = 100_000_00, transfer = 15000_00)
    visualPrint(transfer = 25000_00)
}

fun visualPrint(type: String = vk, previousBuy: Int = 0, transfer: Int) {
    println("................................................")
    println("Сумма: " + rubConvert(transfer))
    println("Тип карты: $type")
    println("Переводы в этом месяце: " + rubConvert(previousBuy))
    println("Комиссия: " + rubConvert(commission(type, previousBuy, transfer)))
}

fun commission(type: String, previousBuy: Int, transfer: Int): Int {
    when (type) {
        maestro, master -> {
            return if ((previousBuy + transfer) in (1..maxMaestro)) 0
            else (fixMaestro + percentMaestro * transfer).toInt()
        }
        visa, mir -> {
            return if (percentVisa * transfer > fixMaestro)
                (percentVisa * transfer).toInt()
            else fixVisa
        }
        vk -> {
            return (percentVk * transfer)
        }
    }
    return 0
}

fun rubConvert(amount: Int): String {
    return (amount / 100).toString() + " руб " + amount % 100 + " коп"
}
import core.operations.VendingMachine
import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Input file name required")
    }
    val input = File(args[0]).reader().readText()
    val vendingMachine  = VendingMachine.getInstance(input)
    vendingMachine.process()
    vendingMachine.reset()
}

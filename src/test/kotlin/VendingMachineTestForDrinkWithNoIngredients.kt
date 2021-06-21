import core.operations.VendingMachine
import org.junit.Assert
import org.junit.Test
import java.io.File

class VendingMachineTestForDrinkWithNoIngredients {
    var vendingMachine: VendingMachine? = null
    @Test
    @Throws(Exception::class)
    fun testDrinkWithNoIngredients() {
        val filePath = "src/test/resources/input_3.json"
        val jsonInput: String = File(filePath).reader().readText()
        vendingMachine = VendingMachine.getInstance(jsonInput)
        vendingMachine!!.process()
        Assert.assertEquals(7, vendingMachine!!.vendingMachineDescriptor!!.teaCoffeeMachine.beverages.size)
    }
}

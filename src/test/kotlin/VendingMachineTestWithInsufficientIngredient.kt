import core.operations.VendingMachine
import org.junit.Assert
import org.junit.Test
import java.io.File

class VendingMachineTestWithInsufficientIngredient {
    var vendingMachine: VendingMachine? = null

    @Test
    @Throws(Exception::class)
    fun testInsufficientIngredient() {
        val filePath = "src/test/resources/input_2.json"
        val jsonInput: String = File(filePath).reader().readText()
        vendingMachine = VendingMachine.getInstance(jsonInput)
        vendingMachine!!.process()
        Assert.assertEquals(4, vendingMachine!!.vendingMachineDescriptor!!.teaCoffeeMachine.beverages.size)
    }
}

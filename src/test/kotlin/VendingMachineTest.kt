import core.operations.VendingMachine
import org.junit.Assert
import org.junit.Test
import java.io.File

class VendingMachineTest {
    private var vendingMachine: VendingMachine? = null

    @Test
    @Throws(Exception::class)
    fun testForOutletsValidInput() {
        val filePath = "src/test/resources/input.json"
        val jsonInput: String = File(filePath).reader().readText()
        vendingMachine = VendingMachine.getInstance(jsonInput)
        vendingMachine!!.process()
        Assert.assertEquals(4, vendingMachine!!.vendingMachineDescriptor!!.teaCoffeeMachine.beverages.size)
    }
}

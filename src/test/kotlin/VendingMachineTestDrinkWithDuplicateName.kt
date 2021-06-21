import core.operations.VendingMachine
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File

class VendingMachineTestDrinkWithDuplicateName {
    var vendingMachine: VendingMachine? = null

    @Test
    @Throws(Exception::class)
    fun testForDrinkWithDuplicateName() {
        val filePath = "src/test/resources/input_4.json"
        val jsonInput: String = File(filePath).reader().readText()
        vendingMachine = VendingMachine.getInstance(jsonInput)
        vendingMachine!!.process()
        Assert.assertEquals(4, vendingMachine!!.vendingMachineDescriptor!!.teaCoffeeMachine.beverages.size)
    }
}

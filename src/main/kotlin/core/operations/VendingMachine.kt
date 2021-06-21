package core.operations

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sun.org.slf4j.internal.Logger
import com.sun.org.slf4j.internal.LoggerFactory
import core.InventoryManager
import core.SingletonHolder
import core.operations.tasks.BeverageMakerTask
import core.operations.tasks.TaskRejectionHandler
import models.Beverage
import models.VendingMachineDescriptor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**Represents a physical Coffee Machine, which can serve in PARALLEL, using multi threading.
 * Singleton Class to simulate a VendingMachine
 * Supports adding beverage requests, with a maximum pending queue size = MAX_QUEUED_REQUEST*/

class VendingMachine {
    private val logger: Logger = LoggerFactory.getLogger(VendingMachine::class.java)

    var vendingMachineDescriptor: VendingMachineDescriptor? = null
    private var inventoryManager: InventoryManager? = null
    private val MAX_QUEUED_REQUEST = 50
    private var executor: ThreadPoolExecutor? = null
    private val mapper = jacksonObjectMapper()

    /**
     * makes class singleton in nature
     * will return VendingMachine.INSTANCE is it already exits else creates one
     *
     */
    companion object : SingletonHolder<VendingMachine, String>(::VendingMachine)

    private constructor(jsonInput: String) {
        println("Vending Something Fresh!!")
        vendingMachineDescriptor = mapper.readValue(jsonInput, VendingMachineDescriptor::class.java)
        val outlet: Int = vendingMachineDescriptor!!.teaCoffeeMachine.outlets.count
        executor =
            ThreadPoolExecutor(outlet, outlet, 5000L, TimeUnit.MILLISECONDS, LinkedBlockingQueue(MAX_QUEUED_REQUEST))
        executor!!.rejectedExecutionHandler = TaskRejectionHandler()
    }

    fun process() {
        inventoryManager = InventoryManager.instance
        val ingredients: Map<String, Int> = vendingMachineDescriptor!!.teaCoffeeMachine.totalItemsQuantity
        for (key in ingredients.keys) {
            inventoryManager!!.addInventory(key, ingredients[key]!!)
        }
        val beverages: HashMap<String, HashMap<String, Int>> = vendingMachineDescriptor!!.teaCoffeeMachine.beverages
        for (key in beverages.keys) {
            val beverage = Beverage(key, beverages[key]!!)
            addBeverageRequest(beverage)
        }
    }

    private fun addBeverageRequest(beverage: Beverage?) {
        val task = BeverageMakerTask(beverage!!)
        executor!!.execute(task)
    }

    private fun stopMachine() {
        executor!!.shutdown()
    }

    //Additional functionality given in case of resetting (not in given scope currently)
    fun reset() {
        logger.debug("Resetting")
        stopMachine()
        inventoryManager!!.resetInventory()
    }
}

package core.operations.tasks

import core.InventoryManager

import models.Beverage


class BeverageMakerTask internal constructor(private val beverage: Beverage) : Runnable {
    override fun run() {
        if (InventoryManager.instance.checkAndUpdateInventory(beverage)) {
            println(beverage.name.toString() + " is prepared")
        }
    }

    override fun toString(): String {
        return beverage.name
    }
}
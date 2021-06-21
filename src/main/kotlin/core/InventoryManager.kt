package core

import models.Beverage


class InventoryManager private constructor() {
    private val inventory = HashMap<String, Int>()

    private object InventoryManagerHolder {
        val instance = InventoryManager()
    }

    fun checkAndUpdateInventory(beverage: Beverage): Boolean {
        synchronized(this) {
            val requiredIngredientMap: Map<String, Int> = beverage.composition
            var isPossible = true
            for (ingredient in requiredIngredientMap.keys) {
                val ingredientInventoryCount = inventory.getOrDefault(ingredient, -1)
                if (ingredientInventoryCount == -1 || ingredientInventoryCount == 0) {
                    println(
                        beverage.name + " cannot be prepared because " + ingredient + " is not available"
                    )
                    isPossible = false
                    break
                } else if (requiredIngredientMap[ingredient]!! > ingredientInventoryCount) {
                    println(
                        beverage.name + " cannot be prepared because " + ingredient + " is not sufficient"
                    )
                    isPossible = false
                    break
                }
            }
            if (isPossible) {
                for (ingredient in requiredIngredientMap.keys) {
                    val existingInventory = inventory.getOrDefault(ingredient, 0)
                    inventory[ingredient] = existingInventory - requiredIngredientMap[ingredient]!!
                }
            }
            return isPossible
        }

    }

    fun addInventory(ingredient: String, quantity: Int) {
        val existingInventory = inventory.getOrDefault(ingredient, 0)
        inventory[ingredient] = existingInventory + quantity
    }

    fun resetInventory() {
        inventory.clear()
    }

    companion object {
        val instance: InventoryManager
            get() = InventoryManagerHolder.instance
    }
}

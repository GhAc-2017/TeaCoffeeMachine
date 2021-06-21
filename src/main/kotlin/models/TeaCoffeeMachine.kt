package models

import com.fasterxml.jackson.annotation.JsonProperty

data class VendingMachineDescriptor(
    @JsonProperty("machine")
    val teaCoffeeMachine: TeaCoffeeMachine
)

data class TeaCoffeeMachine (
    val outlets: Outlet,
    @JsonProperty("total_items_quantity")
    val totalItemsQuantity: HashMap<String, Int>,
    @JsonProperty("beverages")
    val beverages: HashMap<String, HashMap<String, Int>>
)

data class Outlet(
    @JsonProperty("count_n")
    val count: Int
)
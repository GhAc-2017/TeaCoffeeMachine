

# Algorithm
```
* A multithreaded(for n parallel operation) system with n threads is invoked to represent n outlet coffee machine.

* It can queue up all the beverage making requests from the input and tries to create the beverages with the help of central inventory management system

* Feature to add new ingredient in our Inventory & add new Beverage Requests at any time is given.

* Importance has been given to thread safety such that no two drinks use same ingredient.
```

# Testcases
```
I have written different scenarios testcases to different files,
as the functionality I made was singleton so I created multiple files
for testing different scenarios
```

* setup / Run app 
```
mvn clean install
run the main function of TeaCoffeeMachineApplication.kt
```
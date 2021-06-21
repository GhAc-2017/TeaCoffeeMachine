

# Algorithm:
```
* A multithreaded system with n threads is invoked to represent n outlet coffee machine.

* It queues up all the beverage making requests from the input and tries to create the beverages with the help of central inventory management system

* Feature to add new ingredient in our inventory is given, as well as to add new Beverage Requests at any given point of time.

* Importance has been given to thread safety to ensure two drinks do not use same ingredient.
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
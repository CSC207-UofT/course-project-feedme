# Design document
##Major design decisions in Order System (Jing Liu)
### Major design and rationale
Our previous design for the order system did not have a specific UI. Instead, it combines UI, input and output 
boundary, and controller all in one class, which definitely violated the clean architecture. In our new design for 
order system，we tease apart these classes into UI, InOut, controller, and usecase to avoid violation of clean 
architecture. We also decided to add another entity class `Cart` to store list of `products` before order is made 
because in this way it's easier to edit the list of products.

### How it follows clean architecture?
Our system follows clean architecture in a way that each UI does not directly interact with controller but through 
input and out put boundary. Moreover, each controller has its own UseCase class to access entity classes instead of 
directly accessing entity classes, so it follows clean architecture.

### How it follows SOLID
Order system follows the single responsibility principle. Since each UI and its own controller, and each controller 
has its own usecase class, each class only has one ownership which follows single responsibility principle. Order 
system also follows open/closed principle. Since each controller’s InOut interface is implemented by SystemInOut, 
it is open for extension but closed for modification. The order system has small, specific InOut interface which 
follows interface segregation principle.

## Major design decisions in Customer class and implementing factory design pattern (Allen Liu)
For the entity layer, we implement two new entity classes, RegularCustomer and PremiumCustomer, they both inherit  
from class Customer. Moreover, we also add more features for entity class Order. More specifically, now an order 
contains some information about the restaurant, the customer and delivery person, and also implements corresponding 
getter methods. In the use case, we add a new method called matchDeliveryPerson in OrderManager. Basically, this 
method is used for matching orders with delivery people based on the different types of customer. For an order from 
a regular customer, the system will match the delivery person randomly. For orders from premium customers, the 
system will match delivery people who drive cars or ride bikes first.

For the design pattern, we build a factory pattern. When a new customer signs up, the system will let the customer 
choose which type of customer is, and instantiate the class, e.g. RegularCustomer or PremiumCustomer.
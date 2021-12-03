# Progress report

## Jing Liu
### Progress
In Phase 1, I partially finished the order system, which includes writing the following classes/interfaces:
- `Main`
- `SystemInOut`
- `BrowsingUI`
- `BrowsingController`
- `BrowsingUseCase`
- `OrderUI`
- `OrderController`
- `restaurantList`
- `CartUseCase`

I also overwrote `toString` in `Product`, `Restaurant`, `CartUseCase`, `RestaurantGatherer`, `restaurantLIst`, which 
is required for displaying the list of restaurants and menus.

`BrowsingUI` is designed for customer to view restaurants’ menus and decide if they would like to make an order. If
they would, they will select which restaurant they would like to order. If the customer decides not to order, then
the software will exit here. If the customer decides to order, then an `OrderUI` will be initiated to continue
ordering process. Each UI has its own controller, and each controller has its own input and output boundary which
is implemented by the SystemInOut. `SystemInOut` is an input and output boundary which is responsible for sending
input and output between UI and Controller, which follows clean architecture. Moreover, each controller has its own
UseCase class to access entity classes instead of directly accessing entity classes, so it makes sure that it's 
following the clean architecture.

### TODO
In Phase 2, I will finish the order system and write testcases. If there is extra time, I will implement GUI features.

## Lulu Cheng
I worked with Francis to complete the interaction between our software and the restaurant owner. To meet the clean 
architecture structure. We started with a restaurantManager. Our restaurant system controller is based on the 
restaurantManager. Besides, we will have 3 options for restaurant owner to choose: receive order, edit menus and 
order history. If the restaurant owner enter edit menu, we will continue to ask for the id of the product they want 
to modify, and if the product does exists, we will continue to give them the option to modify the product name, 
stock and price. If the product does not exist, we will add a new product to the menu based on the new product 
information they entered. As for the orderHistory and receiveOrders functions, they are used to present orders and 
dispatch orders respectively. Actually, our restaurant interface is not so complete right now, more functions will 
be extended in phase2. In the future, we are planning to add more details, such as personalize our menu by adding 
more characteristics to different items, make the restaurant owner have more choices for order and product editing, etc.

## Bingchen Liu
### Progress
Build following new files:
- `RegularCustomer`
- `PremiumCustomer`
- `CustomerFactory`
- `AddOrderToHistoryTest`
- `CustomerFactoryTest`
- `PremiumCustomerTest`

Upadte following files:
- `User`
- `DeliveryPerson`
- `Order`

For the entity layer, I implement two new entity classes, `RegularCustomer` and `PremiumCustomer`, which both inherit from class `Customer`. Moreover, I also add more features for the entity class `Order`. More specifically, now an order contains some information about the restaurant, the customer and delivery person, and also implements corresponding getter methods. In the use case, I add a new method called `matchDeliveryPerson` in `OrderManager`. Basically, this method is used for matching orders with delivery people based on the different types of customers. For orders from a regular customer, the system will match the delivery person randomly. For orders from premium customers, the system will match delivery people who drive cars or ride bikes first. For entity class `User`, I add a new attribute called `orderHistory`, whcih shows the history order for all users(`Restaurant`, `Customer` and `DeliveryPerson` inherit attribute `orderhistory`).
For entity `DeliveryPerson`, I add new attribute called `transport` and corresponding getter method.

For the design pattern, I build a factory pattern. When a new customer signs up, the system will let the customer choose which type of customer is, and instantiate the class, e.g. `RegularCustomer` or `PremiumCustomer`.

### TODO
- Combine factory pattern with Login system
- Design the UI for Login and Signup
- Implement Command Design Pattern in `Order`


## Edward Wang
### Progress
- Data access
- Created few classes specifically interact with the data file
- Login and Sign up system completed. Specifically finished controller and UI.
- Also wrote the test for above classes.

### TODO
- Serialize all the objects that need to be saved.
- Automatically direct to desire User interface when client tries to login.
- Create a class for transferring data between classes.

## Bowen Liang
### Progress
Work on use case restaurantManager. It is able to edit menu and has some uncalled methods for future planning.

### TODO
Achieve the function for the restaurant user to receive orders from the customers and distribute orders to delivery 
person.

### Huiru Tan
### Progress
- Write the DeliveryManager part
- Write the DeliverySystemController part
- Write the database for DeliveryPerson

### TO DO
-	Connect DeliveryController to DeliveryManager
-	Create UserInterface “UI” for DeliveryPerson

For the Usecase DeliveryManager, it is used to check if the information of the delivery man is valid, then add the valid
deliver men to an ArrayList. Then, a list of DeliveryPeople will be returned. And then, OrderManager will be accessed by
getOrderId method and get current order. The public void DeliverOrder method is used to set order status to be 
“delivered” and store the order in order history. For the DeliverySystemController, it is used to call the methods in 
DeliveryManager and realize “deliver” function by connecting the UserInterface.


## Well done:
- As we working on our project, we always try to follow the clean architecture.



## Open Questions
- How to set the file path that directly access to the file under the same project, instead of writing out the whole 
path. For example: “C://user//...”
- Serialization would face a issue that says invalid stream header: efbfbdef (urgent problem.)

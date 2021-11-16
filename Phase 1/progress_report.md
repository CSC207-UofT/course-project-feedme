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
In Phase 2, I will finish the order system and write testcases. If there are extra, I will implement GUI features.

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


## Well done:
- As we working on our project, we always try to follow the clean architecture.



##Open Questions
- How to set the file path that directly access to the file under the same project, instead of writing out the whole 
path. For example: “C://user//...”
- Serialization would face a issue that says invalid stream header: efbfbdef (urgent problem.)
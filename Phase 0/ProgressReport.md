## Phase0 Progress Report

### Summary of Specification
This is a food delivery software that allows users to browse and order food in the local restaurants. This software 
is designed specifically for customers, restaurant workers, and delivery people. Unlike other apps that have 
different apps for different types of users, this software integrated all three interfaces into a single software.

### Summary of CRC
We designed our crcCards in the order of clean Architecture from inside-out dependencies. Firstly, we start with the 
Entity layer, which is the most fundamental layer of the model: `Restaurant`, `Customer`, `DeliveryPerson`, `Order` and 
`Product` are the objects we considered in this section. The first three of them are subclasses of an abstract class 
User due to some of their common characteristics. Step further, we thought about use cases depending on entities 
which are` OrderManager`, `ProducerManager`, `RestaurantManager` and `UserManager` holding logic of management 
system mode. As for the outer layer, the only class we have for controllers is `SignUp`, but there will definitely be 
more classes as the project develops. However, you can hardly find a single trace of our first CRC cards version 
since we came up with lots more ideas and better ways to achieve our goal as the coding progressed.

### Summary of Skeleton Code
The skeleton code contains six entity classes(`User`, `Restaurant`, `Customer`, `DeliveryPerson`, `Product` and 
`Order`); four use cases(`OrderManager`, `ProductManager`, `RestaurantManager` and `UserManager`); one controller 
(`UserSystemController`); one basic command line interface(`Systemoutput`); four unittest(`UserTest`, 
`RestaurantTester`,  `CustomerTest` and `OrderTest`).

### Open Quesitons
- Struggling what to implement for ProductManager and RestaurantManager.
- How do I use the controller (sign up) or possibly login?
- Confusing about what methods belong to Entity class and what belongs to Usecases.
- Don’t know how to add distance to our software.(what is distance?)
- Struggling to figure out the specific relationship between the entity with their manager.
- Trying to find a way to add logIn functionality more easily.
- When should the `final` keyword be used?

### What has worked well?
- We changed the `productList` in `Order` from a List to a HashMap which has the product (Product) as keys and the 
  quantity of products (Integer) as values. This allows users to add and remove products with entered quantities.
- We have regular weekly group meetings. Communications in the group has worked well.

### Progress
#### Jing Liu
- Discussed project ideas, specifications, and CRC cards with the group, and wrote specification. 
- Finished `Order` class.
- Wrote methods for `User`, `Customer`, `Restaurant`, cna `Product` classes.
- Wrote unit tests for `User`.

#### Edward Wan
- Discussed the whole project idea, encouraged to think about potential functions to be implemented.
- Set up a basic outline for code (creating possible files classes).
- Finished scenario walk-through and partial README
- `SystemOutput` for demo purposes
- Write `Usermaneger` according to the function of SystemOutput
- Set next steps goal for our group

#### Lulu Cheng
- Joining the discussion about the specification and CRC Cards model. Collecting the opinion and forming a primary 
  edition of the CRC model for the entity layer. Generating the CRC cards for the use case and controller according 
  to the code.
- Write the `OrderManager` and `ProductManager` parts.
- Write the unittests for the `Product` and join to write the unittests for the `Restaurant`.

#### Bowen Liang
- Joining the discussion about the specification and CRC Cards model. Modifying the CRC cards in time by monitoring 
  the change of the coding. Identify problems in the CRC cards and provide feedback to the team members to readjust 
  the code.
- Discussing and enriching the content in `ProductManager` and `OrderManager`.
- Write the `RestaurantManager` part.

#### Huiru Tan
- Discussed with group members for specification and and designing the CRC card.
- Discussed with group members for helping implement the above classes.
- Wrote unittests for `Customer`.

#### Bingchen Liu
- Join in every group meeting and discuss ideas with group members.
- Implement Class `Order` and modify Class `Restaurant`.
- Implement controller `UserSystemController`
- Write JavaDoc for Class `User`,  `Restaurant`, `Customer`, `DeliveryPerson`, `Product` and `Order`.
- Write unittest for `Order` and `Restaurant`.
- Write summary of skeleton program

### Next Step
We be divided into two subgroups:  
- Edward Wan and Huiru Tan will finish the Login/Signup System.
- Jing Liu, Bingchen Liu, Lulu Cheng, and Bowen Liang will finish the order system (customer can make an order, 
restaurant can confirm order, delivery person can pick up order)
- Code implementation:
  - Login/Signup System 
  - Customer: view Restaurant’s product, make an order
  - Restaurant: Add/Edit products, accepting order
  - Delivery man: accepting order
- More test case is needed as we implement more classes
- Improve code for cleanliness as finalized in the class.



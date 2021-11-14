package Controller;

import Entity.Order;
import Entity.Product;
import UseCases.RestaurantManager;

public class RestaurantSystemController {
    private final RestaurantManager resManager;

    public RestaurantSystemController(RestaurantManager resManager){this.resManager = resManager;}

    public Product create(String name, double price, int stock) {
        return resManager.createProduct(name, price, stock);
    }

    public void editprice(int productID, double price){
        resManager.editPrice(productID, price);
    }

    public void editname(int productID, String name){
        resManager.editName(productID, name);
    }

    public void editRestaurantMenu(int productID, int stock){
        resManager.editRestaurantMenu(productID, stock);
    }

    public void receive(Order order){
        resManager.receiveOrder(order);
    }

    public void OrderHistory(){
        resManager.getOrderHistory();
    }

    public void Distributed(){
        resManager.getReadyToDistribute();
    }

    public void getMenu(){
        resManager.getMenu();
    }

    public boolean contain(int productID){
        return resManager.containProduct(productID);
    }
}

package UseCases;

import Entity.Product;
import Entity.Restaurant;

import java.util.*;


public class BrowsingUseCase {

    private final restaurantList restaurants;
    private final HashMap<String, Restaurant> list = new HashMap<>();

    public BrowsingUseCase() {
        this.restaurants = new restaurantList();
        int count = 1;
        for (Restaurant restaurant: restaurants.restaurantsGetter()) {
            this.list.put(String.valueOf(count), restaurant);
            count++;
        }
    }

    public String showRestaurants() {
        return restaurants.toString();
    }

    public Restaurant getRestaurant(String num) {
        return this.list.get(num);
    }

    public boolean verifyRestautantSeleciton(String num) {
        return this.list.containsKey(num);
    }

    public String showRestaurantName(String num) {
        return this.list.get(num).toString();
    }

    public String showMenu(String num) {
        List<Product> list = this.list.get(num).getRestaurantMenu();
        StringBuilder menu = new StringBuilder();
        int count = 1;
        for (Product product: list) {
            menu.append(count + ": " + product  );
        }
        return menu.toString();
    }





}


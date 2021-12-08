package UseCases;

import Entity.Product;
import Entity.Restaurant;

import java.util.*;

/**
 * Usecases for BrowsingController.
 */
public class BrowsingUseCase {

    private final RestaurantList restaurants;
    private final HashMap<String, Restaurant> list = new HashMap<>();

    /**
     * Initiating a new BrowsingUseCase will obtain a restaurants' list and a Map.
     */
    public BrowsingUseCase() {
        this.restaurants = new RestaurantList();
        int count = 1;
        for (Restaurant restaurant: restaurants.restaurantsGetter()) {
            this.list.put(String.valueOf(count), restaurant);
            count++;
        }
    }

    /**
     * Show the list of restaurants
     * @return A string of restaurants
     */
    public String showRestaurants() {
        return restaurants.toString();
    }

    /**
     * Get restaurant by number
     * @param num Number of the restaurant
     * @return The restaurant
     */
    public String getRestaurant(String num) {
        return this.list.get(num).getUserPhone_num();
    }

    /**
     * Verify if the restaurant is in the list
     * @param num The number of the restaurant
     * @return true if restaurant is in the list or false if not
     */
    public boolean verifyRestautantSeleciton(String num) {
        return this.list.containsKey(num);
    }

    /**
     * Show restaurant name
     * @param num The number of the restaurant
     * @return A string of the restaurant name
     */
    public String showRestaurantName(String num) {
        return this.list.get(num).toString();
    }

    /**
     * Show the menu of the restaurant
     * @param num The number of the restaurant
     * @return The string of the restaurant's menu
     */
    public String showMenu(String num) {
        List<Product> list = this.list.get(num).getRestaurantMenu();
        StringBuilder menu = new StringBuilder();
        int count = 1;
        for (Product product: list) {
            menu.append(count).append(": ").append(product).append("\n");
            count ++;
        }
        return menu.toString();
    }

    /**
     * Get the phone number of the selected restaurant
      * @param restaurant The selected restaurant
     * @return The string of the restaurant's phone number
     */
    public String restaurantNum(Restaurant restaurant) {
        return restaurant.getUserPhone_num();
    }

    /**
     * Get the restaurant according to the given phone number of the selected restaurant
     * @param resNum The selected restaurant phone number
     * @return The restaurant
     */
    public Restaurant findRestaurant(String resNum){
        return list.get(resNum);
    }


}


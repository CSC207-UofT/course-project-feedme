package UseCases;
import Entity.Restaurant;
import java.util.List;


/**
 * This class is for getting all the restaurants from data files
 */
public class RestaurantList {


    UserReadWrite userReadWrite = new UserReadWrite();
    private final List<Restaurant> restaurants = userReadWrite.readRestaurants();

    /**
     * Get all restaurants form data file
     * @return a list of Restaurants
     */
    public List<Restaurant> restaurantsGetter() { return restaurants; }

    /**
     * Find Restaurant by its phone number
     * @param restaurantNum The phone number of the restaurant
     * @return The restaurant entity
     */
    public Restaurant findRestaurnat(String restaurantNum) {
        for (Restaurant restaurant: this.restaurants) {
            if (restaurant.getUserPhone_num().equals(restaurantNum)){
                return restaurant;
            }
        }
        return null;
    }

    /**
     * Print all restaurants.
     * @return A formatted string of restaurants
     */
    @Override
    public String toString() {
        int count = 1;
        StringBuilder list = new StringBuilder("\nHere is the list of restaurants:\n");
        for (Restaurant restaurant: this.restaurants) {
            String line = count + ": " + restaurant + "\n";
            list.append(line);
            count++;
        }
        list.append("\nPlease enter restaurant's number to view its menu:");
        return list.toString();
    }
}

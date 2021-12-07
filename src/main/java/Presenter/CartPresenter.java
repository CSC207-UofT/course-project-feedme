package Presenter;

import UseCases.CartUseCase;

/**
 * Presenter for CartController
 */
public class CartPresenter {

    private final CartUseCase cartUseCase;

    /**
     * Initiation CartPresenter
     * @param restaurantNum (String) the restaurant's phone number
     */
    public CartPresenter (String restaurantNum) {
        this.cartUseCase = new CartUseCase(restaurantNum);
    }

    /**
     * Show restaurant's name
     * @return (String) Restaurant's name
     */
    public String showRestaurantName() {
        return "\n" + cartUseCase.showRestaurantName() + ":";
    }

    /**
     * Show restaurant's menu
     * @return (String) Restaurant's menu
     */
    public String showRestaurantMenu() {
        return "\n" + cartUseCase.showMenu();
    }

    /**
     * Ask customer to select product
     * @return (String) Asking for product selection
     */
    public String askProductSelection(){
        return "\nPlease enter the number of the product that you would like to order: ";
    }

    /**
     * Show message for invalid input
     * @return (String) invalid input message
     */
    public String invalidMessage() {
        return "\nInvalid input. please check the menu and re-enter the number.\n";
    }

    /**
     * Show error message for exception
     * @return (String) error message for exception
     */
    public String errorMessage() {
        return "Something went wrong";
    }

    /**
     * Ask customer to enter the quantity of the product that they would like to oerder
     * @return (String) Asking for product quantity
     */
    public String askQuantity() {
        return "\nPlease enter the quantity you would like to order:";
    }

    /**
     * Show success message after the item is added to the cart
     * @return (String) success message
     */
    public String showSuccess() {
        return "\nItem has successfully added to cart";
    }

    /**
     * Show message for insufficient stock
     * @return (String) message for not enough stock
     */
    public String noStock(){
        return "\nSorry, there isn't enough stock";
    }

    /**
     * Ask customer if they would like to submit the order
     * @return (String) asking for selection that if they are ready to submit order
     */
    public String askSubmitOrder() {
        return "\nPlease type '1' if you would like to order another item, type '2' if you are ready " +
                "to submit your order";
    }


}

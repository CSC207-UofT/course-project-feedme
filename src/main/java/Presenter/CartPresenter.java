package Presenter;

import UseCases.CartUseCase;

public class CartPresenter {

    private final CartUseCase cartUseCase;

    public CartPresenter (String restaurantNum) {
        this.cartUseCase = new CartUseCase(restaurantNum);
    }

    public String showRestaurantName() {
        return "\n" + cartUseCase.showRestaurantName() + ":";
    }

    public String showRestaurantMenu() {
        return "\n" + cartUseCase.showMenu();
    }

    public String askProductSelection(){
        return "\nPlease enter the number of the product that you would like to order: ";
    }

    public String invalidMessage() {
        return "\nInvalid input. please check the menu and re-enter the number.\n";
    }

    public String errorMessage() {
        return "Something went wrong";
    }

    public String askQuantity() {
        return "\nPlease enter the quantity you would like to order:";
    }

    public String showSuccess() {
        return "\nItem has successfully added to cart";
    }

    public String noStock(){
        return "\nSorry, there isn't enough stock";
    }

    public String askSubmitOrder() {
        return "\nPlease type '1' if you would like to order another item, type '2' if you are readly " +
                "to submit your order";
    }


}

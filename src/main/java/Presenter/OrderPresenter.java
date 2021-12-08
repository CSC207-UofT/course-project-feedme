package Presenter;

/**
 * Presenter for OrderController
 */
public class OrderPresenter {

    /**
     * Show success message
     * @param id (String) order id
     * @return (String) success message
     */
    public String successMessage(String id) {
        return "\nOrder has been successfully created! Your order id is: " + id;
    }

}

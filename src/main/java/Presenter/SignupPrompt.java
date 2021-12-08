package Presenter;

public class SignupPrompt {
    private String language = "English";
    public String askNewName(){
        return "Thank you to join Feed Me! May I get your name please?";
    }

    public String askNewPhone(){
        return "Now, I need your phone number, you would need to use phone number to login.";
    }

    public String askNewPassword(){
        return "We have received your phone number, please enter your login password now.";
    }
    public String askNewType(){
        return "Would you like to become customer, restaurant partner or deliver man? please enter " +
                "one character c (customer), r (restaurant), d (deliver man)";
    }

    public String askCustomerAddress(){
        return "Thanks for becoming our honorable customer, the last steps for us is for you to " +
                "provide your address.";
    }

    public String askRestaurantAddress(){
        return "Thank you for partnering with FeedMe, the last step we would like to know your " +
                "restaurant location.";
    }

    public String greetCusRest(){
        return "We have created your account, you are now able to login!";
    }

    public String thankDperson(){
        return "Thank you for delivery for us! We have created your account, please login now!";
    }

    public String alreadyRegister(){
        return "You have already registered with us. Please login with your phone number";
    }



}
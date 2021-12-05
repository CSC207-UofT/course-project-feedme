package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.io.FileWriter;
import java.io.IOException;

public class UserWriter {
//    public void addUser(String name, String phone_num, String password, String type_, String address){
//        try (FileWriter file = new FileWriter("users.txt", true)){
//            String user = name + "," + phone_num +"," + password + "," + type_;
//            if (type_.equals("c") || type_.equals("r")){user += ","+ address + "\n";}
//            else{user += "\n";}
//            file.write(user);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    public void saveToFile(User user){
        String name;
        if (user instanceof Customer) {
            name = "customer.txt";
        } else if (user instanceof DeliveryPerson) {
            name = "deliveryperson.txt";
        } else {
            name = "restaurant.ser";
        }
        try (FileWriter file = new FileWriter(name, true)){
            String userdata;
            userdata = user.getUserName() + ',' + user.getUserPhone_num() + ',' + user.getUserPassword() + ',' +
                    user.getUserType();
            if (user instanceof Customer){userdata += ',' + ((Customer) user).getCustomerAddress() + "\n";}
            if (user instanceof Restaurant){userdata += ',' + ((Restaurant) user).getRestaurantAddress() + "\n";}
            else {userdata += "\n";}
            file.write(userdata);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}


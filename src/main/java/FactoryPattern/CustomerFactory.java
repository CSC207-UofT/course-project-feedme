package FactoryPattern;

import Entity.Customer;
import Entity.PremiumCustomer;
import Entity.RegularCustomer;

public class CustomerFactory {
   public Customer makeCustomer(String customerType, Customer customer) {
       if (customerType.equalsIgnoreCase("Regular")) {
           return new RegularCustomer(customer.getUserName(), customer.getUserPhone_num(), customer.getUserPassword(),
                   customer.getCustomerAddress());
       } else if (customerType.equalsIgnoreCase("Premium")) {
           return new PremiumCustomer(customer.getUserName(), customer.getUserPhone_num(), customer.getUserPassword(),
                   customer.getCustomerAddress());
       }
       return null;
   }
}

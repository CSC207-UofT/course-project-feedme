package FactoryPattern;

import Entity.Customer;
import Entity.PremiumCustomer;
import Entity.RegularCustomer;

public class CustomerFactory {
    public Customer makeCustomer(Customer customer) {
        if (customer instanceof RegularCustomer) {
            return new RegularCustomer(customer.getUserName(), customer.getUserPhone_num(), customer.getUserPassword(),
                    customer.getCustomerAddress());
        }
        else if (customer instanceof PremiumCustomer) {
            return new RegularCustomer(customer.getUserName(), customer.getUserPhone_num(), customer.getUserPassword(),
                    customer.getCustomerAddress());
        }
        return null;
    }
}

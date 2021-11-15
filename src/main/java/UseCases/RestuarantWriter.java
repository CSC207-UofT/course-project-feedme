package UseCases;

import Entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RestuarantWriter implements Serializable {

    public boolean add_restaurant(String name, Product[] list) {
        try {
            FileOutputStream fileIn = new FileOutputStream("/src/data/restaurant_product.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fileIn);


        }
        catch (IOException e) {
            e.printStackTrace();
            }

        }

    }

}

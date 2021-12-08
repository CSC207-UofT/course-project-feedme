package Entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1;

    private String name;
    private final String id;
    private double price;
    private int stock;

    /**
     * Construct a Product, giving the name, id, price and stock.
     *
     * @param name      The name of Product
     * @param id        The id of Product
     * @param price     The price of Product
     * @param stock     The stock of Product
     */
    public Product(String name, String id, double price, int stock){
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
    }


    /**
     * The product's name.
     *
     * @return the product's name.
     */
    public String getProductName(){ return this.name;}

    /**
     * The product's id.
     *
     * @return the product's id.
     */
    public String getProductId() { return this.id; }

    /**
     * The product's price.
     *
     * @return the product's price.
     */
    public double getProductPrice(){
        return this.price;
    }

    /**
     * The product's stock.
     *
     * @return the number of product's stock.
     */
    public int getProductStock() { return this.stock; }

    /**
     * Update the product's stock by n.
     * @param n the number of stock that needs to be changed.
     */
    public void updateStock(int n) { this.stock += n; }

    public void setPrice(double price){this.price = price; }

    public void setName(String name){this.name = name; }

    public void setStock(int stock) {this.stock = stock; }

    public void reduceProductStock(int num) {this.stock -= num;}



    /**
     * Return the String representation of the product.
     *
     * @return the name of the product and its price.
     */
    @Override
    public String toString(){
        return this.getProductName() + "\t" + "$" + this.getProductPrice();
    }

}

package Entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1;

    private final String name;
    private final String id;
    private final double price;
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
     * The Product's name.
     *
     * @return the Product's name.
     */
    public String getProductName(){ return this.name;}

    /**
     * The Product's id.
     *
     * @return the Product's id.
     */
    public String getProductId() { return this.id; }

    /**
     * The Product's price.
     *
     * @return a double of Product's price.
     */
    public double getProductPrice(){
        return this.price;
    }

    /**
     * The product's stock.
     *
     * @return the number of Product's stock.
     */
    public int getProductStock() { return this.stock; }

    /**
     * Update the Product's stock by n.
     * @param n the number of stock that needs to be changed.
     */
    public void updateStock(int n) { this.stock += n; }

    /**
     * Return the String representation of the Product.
     *
     * @return the name of the Product and its price.
     */
    @Override
    public String toString(){
        return this.getProductName() + "\t" + "$" + this.getProductPrice();
    }

}

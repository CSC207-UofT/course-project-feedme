package UseCases;

import Entity.Product;
import java.util.ArrayList;
import java.util.List;

class ProductManager {
    protected List<Product> productList;

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    //Create product and add it to the list.
    public void createProduct(Product item) {
        if (!productList.contains(item)) {
            this.productList.add(item);
            this.productList.add(item);
        }
    }

    //Delete product from the list.
    public void deleteProduct(Product item) {
        if (productList.contains(item)) {
            this.productList.remove(item);
        }
    }

    //Return product_list.
    public List<Product> displayProducts() {
        return this.productList;
    }

    //Check if the product is available.
    public Boolean stockAvailability(Product item){
        return item.getProductStock() > 0;
    }
}

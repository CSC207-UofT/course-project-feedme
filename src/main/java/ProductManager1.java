package java;

import java.util.ArrayList;
import java.util.List;

class ProductManager {
    protected List<Product> productlist;

    public ProductManager() {
        this.productlist = new ArrayList<>();
    }

    public void createProduct(Product item) {
        if (!productlist.contains(item)) {
            this.productlist.add(item);
        }
    }
    public void deleteProduct(Product item) {
        if (productlist.contains(item)){
            this.productlist.remove(item);
        }
    }

    public List<Product> displayProducts() {
        return this.productlist;
    }

    public Boolean stockAvailability(Product item){
        return productlist.contains(item);
    }
}

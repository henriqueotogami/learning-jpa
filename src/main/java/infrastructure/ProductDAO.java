package infrastructure;

import model.basic.Product;

public class ProductDAO extends DataAccessObject<Product> {

    public ProductDAO() {
        super(Product.class);
    }
}
